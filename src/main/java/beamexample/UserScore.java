package beamexample;

import org.apache.avro.reflect.Nullable;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.Validation;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.transforms.Sum;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;

/**
 * Created by samo on 2017/4/23.
 *
 * @author samo
 * @date 2017/04/23
 */
public class UserScore {

    interface Options extends PipelineOptions {

        @Description("Path to the data file(s) containing game data.")
        // The default maps to two large Google Cloud Storage files (each ~12GB) holding two subsequent
        // day's worth (roughly) of data.
        @Default.String("gs://apache-beam-samples/game/gaming_data*.csv")
        String getInput();
        void setInput(String value);

        @Description("BigQuery Dataset to write tables to. Must already exist.")
        @Validation.Required
        String getDataset();
        void setDataset(String value);

        @Description("The BigQuery table name. Should not already exist.")
        @Default.String("user_score")
        String getUserScoreTableName();
        void setUserScoreTableName(String value);
    }


    @DefaultCoder(AvroCoder.class)
    static class GameActionInfo {
        @Nullable String user;
        @Nullable String team;
        @Nullable Integer score;
        @Nullable Long timestamp;

        public GameActionInfo() {}

        public GameActionInfo(String user, String team, Integer score, Long timestamp) {
            this.user = user;
            this.team = team;
            this.score = score;
            this.timestamp = timestamp;
        }

        public String getUser() {
            return this.user;
        }
        public String getTeam() {
            return this.team;
        }
        public Integer getScore() {
            return this.score;
        }
        public String getKey(String keyname) {
            if (keyname.equals("team")) {
                return this.team;
            } else {  // return username as default
                return this.user;
            }
        }
        public Long getTimestamp() {
            return this.timestamp;
        }
    }


    public static void main(String[] args) {
        Options options = PipelineOptionsFactory.fromArgs(args).withValidation().as(Options.class);
        Pipeline pipeline = Pipeline.create(options);

        PCollection<String> inputSource = pipeline.apply(TextIO.Read.from(options.getInput()));
        PCollection<GameActionInfo> info = inputSource.apply(
            MapElements.via(
                new SimpleFunction<String, GameActionInfo>() {
                    @Override
                    public GameActionInfo apply(String input) {
                        String[] components = input.split(",");
                        String user = components[0].trim();
                        String team = components[1].trim();
                        Integer score = Integer.parseInt(components[2].trim());
                        Long timestamp = Long.parseLong(components[3].trim());
                        return new GameActionInfo(user, team, score, timestamp);
                    }
                }
            )
        );

        PCollection<KV<String, Integer>> keyinfo = info.apply(
            MapElements.via(
                new SimpleFunction<GameActionInfo, KV<String, Integer>>() {
                    @Override
                    public KV<String, Integer> apply(GameActionInfo input) {
                        return KV.of(input.getKey("user"), input.getScore());
                    }
                }
            )
        );
        PCollection<KV<String, Integer>> result = keyinfo.apply(Sum.<String>integersPerKey());

        //TODO write output


        pipeline.run().waitUntilFinish();


    }
}
