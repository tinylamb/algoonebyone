package beamexample;

import java.util.TimeZone;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.transforms.Sum;
import org.apache.beam.sdk.transforms.WithTimestamps;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by samo on 2017/4/23.
 *
 * @author samo
 * @date 2017/04/23
 */
public class HourlyTeamScore extends UserScore{

    private static DateTimeFormatter fmt =
        DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS")
            .withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("PST")));
    private static DateTimeFormatter minFmt =
        DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm")
            .withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("PST")));

    interface Options extends UserScore.Options {

        @Description("Numeric value of fixed window duration, in minutes")
        @Default.Integer(60)
        Integer getWindowDuration();
        void setWindowDuration(Integer value);

        @Description("String representation of the first minute after which to generate results,"
            + "in the format: yyyy-MM-dd-HH-mm . This time should be in PST."
            + "Any input data timestamped prior to that minute won't be included in the sums.")
        @Default.String("1970-01-01-00-00")
        String getStartMin();
        void setStartMin(String value);

        @Description("String representation of the first minute for which to not generate results,"
            + "in the format: yyyy-MM-dd-HH-mm . This time should be in PST."
            + "Any input data timestamped after that minute won't be included in the sums.")
        @Default.String("2100-01-01-00-00")
        String getStopMin();
        void setStopMin(String value);

        @Description("The BigQuery table name. Should not already exist.")
        @Default.String("hourly_team_score")
        String getHourlyTeamScoreTableName();
        void setHourlyTeamScoreTableName(String value);
    }

    public static void main(String[] args) {
        Options options = PipelineOptionsFactory.fromArgs(args).withValidation().as(Options.class);
        Pipeline pipeline = Pipeline.create(options);

        final Instant stopMinTimestamp = new Instant(minFmt.parseMillis(options.getStopMin()));
        final Instant startMinTimestamp = new Instant(minFmt.parseMillis(options.getStartMin()));

        PCollection<String> inputSource = pipeline.apply(TextIO.Read.from(options.getInput()));
        PCollection<GameActionInfo> info = inputSource.apply(
            MapElements.via(
                new SimpleFunction<String, GameActionInfo>() {
                    @Override
                    public GameActionInfo apply(String input) {
                        try {
                            String[] components = input.split(",");
                            String user = components[0].trim();
                            String team = components[1].trim();
                            Integer score = Integer.parseInt(components[2].trim());
                            Long timestamp = Long.parseLong(components[3].trim());
                            return new GameActionInfo(user, team, score, timestamp);
                        } catch (Exception e) {
                            return null;
                        }
                    }
                }
            )
        ).apply(Filter.by(
            (GameActionInfo ginfo) -> ginfo != null
                && ginfo.getTimestamp() > startMinTimestamp.getMillis()
            && ginfo.getTimestamp() < stopMinTimestamp.getMillis()
        ));

        PCollection<GameActionInfo> infowithTS = info.apply(
            WithTimestamps.of((GameActionInfo tmp) -> new Instant(tmp.getTimestamp()))
        );

        PCollection<GameActionInfo> infoWin = infowithTS.apply(Window.<GameActionInfo>into(
            FixedWindows.of(Duration.standardMinutes(options.getWindowDuration())))
        );

        PCollection<KV<String, Integer>> result = infoWin.apply(
            MapElements.via(
                new SimpleFunction<GameActionInfo, KV<String, Integer>>() {
                    @Override
                    public KV<String, Integer> apply(GameActionInfo input) {
                        return KV.of(input.getKey("team"), input.getScore());
                    }
                }
            )
        ).apply(Sum.<String>integersPerKey());

        //TODO write output

        pipeline.run().waitUntilFinish();


        //apply(Filter.by(
        //    (GameActionInfo ginfo) -> {return ginfo != null
        //        && ginfo.getTimestamp() > startMinTimestamp.getMillis()
        //        && ginfo.getTimestamp() < stopMinTimestamp.getMillis() ;}
        //));


    }
}
