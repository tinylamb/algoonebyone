package basic;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by samo on 2017/4/12.
 *
 * @author samo
 * @date 2017/04/12
 */
public class WordCount {
    public static void main(String[] args) {
        WordCountOptions options = PipelineOptionsFactory.fromArgs(args).withValidation()
            .as(WordCountOptions.class);
        Pipeline p = Pipeline.create(options);
        PCollection<String> lines = p.apply(TextIO.Read.from(options.getInputFile()));
        PCollection<KV<String, Long>> words = lines.apply(ParDo.of(new ExtractWordsFn()));
        //POutput words = lines.apply(ParDo.of(new ExtractWordsFn()));


    }

    public static interface WordCountOptions extends PipelineOptions {
        @Description("path of the file to read from")
        @Default.String("default_file_path")

        /**
         * 获取输入文件
         * @param ruleId 规则id
         * @param page 翻页号
         * @param jsonContext json格式的上下文
         * @return String
         */
        String getInputFile();

        /**
         * 设置输入文件
         * @param value 输入文件
         * @return void
         */
        void setInputFile(String value);

        @Description("Path of the file to write to")
        @Default.String("default_write_file")
        /**
         * 获取输出文件
         * @return String
         */
        String getOutputFile();

        /**
         * 设置输出文件
         * @param value 输出文件
         * @return void
         */
        void setOutputFile(String value);
    }

    static class ExtractWordsFn extends DoFn<String, KV<String, Long>> {
        @ProcessElement
        public void processElement(ProcessContext c) {
            for (String word : c.element().split("[^a-zA-Z']+")) {
                if(!StringUtils.isEmpty(word)) {
                    c.output(KV.of(word, 1L));
                }
            }

        }
    }
}
