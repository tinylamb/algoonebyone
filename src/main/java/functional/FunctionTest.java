package functional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samo on 2017/4/15.
 *
 * @author samo
 * @date 2017/04/15
 */
public class FunctionTest {
    public static void main(String[] args) {
        ExtractInfo<List<String>, String> test = (List<String> ls) -> {
            if(ls == null || ls.isEmpty()) {
                return "null";
            }
            StringBuffer sb = new StringBuffer();
            for(String tmp : ls) {
                sb.append(tmp).append("_");
            }
            if(sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            return sb.toString();
        };
        List<String> lstest = new ArrayList<String>();
        lstest.add("hello");
        lstest.add("world");
        System.out.println(test.extract(lstest));

    }
}
