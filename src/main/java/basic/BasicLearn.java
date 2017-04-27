package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samo on 2017/4/3.
 *
 * @author samo
 * @date 2017/04/03
 */
public class BasicLearn {
    public static class Circle {
        private double r;

        public Circle(double r) {
            this.r = r;
        }

        public double getR() {
            return r;
        }

        public void setR(double r) {
            this.r = r;
        }

        public double getArea() {
            return Math.PI * r * r;
        }

        public void test() {
            List<String> ls = new ArrayList<String>();
            ls.add(3,"str");
            for (String tmp : ls) {
                System.out.println(tmp);
            }
            //String endcodeSer = opSearch.doSearch(endcodeQuery);
            //String encodeVal = OnlineLgtService.parseSearch(endcodeSer, OP_SEARCH_FIELD_ENDCODE);
            //if(StringUtil.isEmpty(encodeVal)) {
            //    predict.put(RESULT_FIELD_RET, -1);
            //    predict.put(RESULT_FIELD_MSG, "not find endcode");
            //    return predict;
            //}

            //4-2 resolve predict search result
            //Map<String, String> keyQuery = OnlineLgtService.
            //    genQueryKeyMap(currentLgt, encodeVal);
            //log.warn("keyQuery: " + keyQuery);
            //String predictSer = opSearch.doSearch(keyQuery);
            //String predictVal = OnlineLgtService.parseSearch(predictSer, OP_SEARCH_FIELD_PREDICT);
            //if(StringUtil.isEmpty(predictVal)) {
            //    predict.put(RESULT_FIELD_RET, -1);
            //    predict.put(RESULT_FIELD_MSG, "not find predict");
            //    return predict;
            //}
            //log.warn("ocurrTime: " + ocurrTime + " predictVal: " + predictVal);
            //String predictTime = OnlineLgtService.
            //    getFormatDateByHours(ocurrTime, Double.parseDouble(predictVal));
            //
            //if(StringUtil.isEmpty(predictTime)) {
            //    predict.put(RESULT_FIELD_RET, -1);
            //    predict.put(RESULT_FIELD_MSG, "get format date err");
            //    return predict;
            //}
            //predict.put(RESULT_FIELD_RET, 0);
            //predict.put(RESULT_FIELD_MSG, "SUCC");
            //predict.put(RESULT_FIELD_PREDICT, OnlineLgtService.tranforTime(predictTime));
            //return predict;
        }
    }
}
