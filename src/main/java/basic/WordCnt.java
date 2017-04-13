package basic;

/**
 * Created by samo on 2017/4/12.
 *
 * @author samo
 * @date 2017/04/12
 */

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Iterator;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Combine;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.commons.lang3.StringUtils;

public class WordCnt {
    static class ExtractWordsFn extends DoFn<String, KV<String, Long>> {
        @ProcessElement
        public void processElement(ProcessContext c) {
            // Split the line into words.
            String[] words = c.element().split("[^a-zA-Z']+");
            // Output each word encountered into the output PCollection.
            for (String word : words) {
                if (!StringUtils.isEmpty(word)) {
                    c.output(KV.of(word, 1L));
                }
            }
        }
    }

    /**
     * A SimpleFunction that converts a Word and Count into a printable string.
     */
    public static class FormatAsTextFn extends SimpleFunction<KV<String, Long>, String> {
        @Override
        public String apply(KV<String, Long> input) {
            return input.getKey() + ": " + input.getValue();
        }
    }

    public static class CountWordCombineFn extends Combine.KeyedCombineFn<String, Long, Long, Long> {
        @Override
        public Long createAccumulator(String s) {
            return 0L;
        }
        @Override
        public Long addInput(String s, Long accum, Long count) {
            return accum + count;
        }
        @Override
        public Long mergeAccumulators(String s, Iterable<Long> iterable) {
            long result = 0L;
            Iterator<Long> accumItor = iterable.iterator();
            while (accumItor.hasNext()) {
                result += accumItor.next();
            }

            return result;
        }
        @Override
        public Long extractOutput(String s, Long accum) {
            return accum;
        }
    }

    public static class CountWordMapFn extends SimpleFunction<KV<String, Iterable<Long>>, KV<String, Long>> {
        @Override
        public KV<String, Long> apply(KV<String, Iterable<Long>> stringIterableKV) {
            String word = stringIterableKV.getKey();
            Iterator<Long> countListItor = stringIterableKV.getValue().iterator();
            long count = 0L;
            while (countListItor.hasNext()) {
                count += countListItor.next();
            }
            return KV.of(word, count);
        }
    }

    public static class CountWords extends PTransform<PCollection<String>, PCollection<KV<String, Long>>> {
        //@Override
        public PCollection<KV<String, Long>> apply(PCollection<String> lines) {

            // Convert lines of text into individual words.
            PCollection<KV<String, Long>> words = lines.apply(
                ParDo.of(new ExtractWordsFn()));

            // Count the number of times each word occurs.
            //1. 使用Combine.perKey统计，会自动按照key调用PerKeyCombineFn计算单词个数
            PCollection<KV<String, Long>> wordCounts =
                words.apply(Combine.perKey(new CountWordCombineFn()));
            //2. 使用GroupByKey将key->value数据归并为key->iterator<value>，然后通过map统计单词个数
            //            PCollection<KV<String, Long>> wordCounts =
            //                    words.apply(GroupByKey.<String, Long>create()).apply(MapElements.via(new CountWordMapFn()));

            return wordCounts;
        }

        @Override
        public PCollection<KV<String, Long>> expand(PCollection<String> input) {
            return null;
        }
    }

    public interface WordCountOptions extends PipelineOptions {
        @Description("Path of the file to read from")
        @Default.String("D:\\data\\programming-guide.txt")
        String getInputFile();

        void setInputFile(String value);

        @Description("Path of the file to write to")
        @Default.String("D:\\data\\programming-guide.result")
        String getOutputFile();

        void setOutputFile(String value);
    }

    public static void main(String[] args) {
        WordCountOptions options = PipelineOptionsFactory.fromArgs(args).withValidation()
            .as(WordCountOptions.class);
        Pipeline p = Pipeline.create(options);

        p.apply("ReadLines", TextIO.Read.from(options.getInputFile()))
            .apply(new CountWords())
            .apply(MapElements.via(new FormatAsTextFn()))
            .apply("WriteCounts", TextIO.Write.to(options.getOutputFile()));

        p.run();
    }
}

