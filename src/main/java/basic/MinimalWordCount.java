package basic;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.KV;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by samo on 2017/4/11.
 *
 * @author samo
 * @date 2017/04/11
 */
public class MinimalWordCount {
    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.create();
        Pipeline p = Pipeline.create(options);

        p.apply(TextIO.Read.from("D:\\data\\programming-guide.txt"))
            .apply("ExtractWords", ParDo.of(
                new DoFn<String, String>() {
                    @ProcessElement
                    public void processElement(ProcessContext c) {
                        for (String word : c.element().split("[^a-zA-Z']+")) {
                            if(!StringUtils.isEmpty(word)) {
                                c.output(word);
                            }
                        }
                    }
                }
            ))
            .apply(Count.<String>perElement())
            .apply("FormatResults", MapElements.via(new SimpleFunction<KV<String, Long>, String>() {
                @Override
                public String apply(KV<String, Long> input) {
                    return input.getKey() + ": " + input.getValue();
                }
            }))
            .apply(TextIO.Write.to("D:\\data\\programming-guide.result"));

    }
}
