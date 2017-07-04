package basic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by samo on 2017/4/20.
 *
 * @author samo
 * @date 2017/04/20
 */
public class MainTest {

    public static void testLs() {
        List<String> ls = new ArrayList<>();
        ls.add(3, "a");
        for(String tmp : ls) {
            if(StringUtils.isEmpty(tmp)) {
                System.out.println("empty");
            } else {
                System.out.println(tmp);
            }
        }
    }

    public static void testObject() {
        Object obj = new Samo();
        ((Samo) obj).sayHi();
    }

    public static void testDouble() {
        Double d = 0.123;
        String v = new DecimalFormat("0.00000000").format(d);
        System.out.println(v);
    }

    public static void main(String[] args) {
        testDouble();
    }
}
