package doFns;

import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by samo on 2017/4/12.
 *
 * @author samo
 * @date 2017/04/12
 */
public class ExtractWordsFn_ extends DoFn<String, KV<String, Long>> {
    @ProcessElement
    public void processElement(ProcessContext c) {
        for (String word : c.element().split("[^a-zA-Z']+")) {
            if(!StringUtils.isEmpty(word)) {
                c.output(KV.of(word, 1L));
            }
        }

    }
}
