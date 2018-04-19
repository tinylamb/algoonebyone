package polymorphism;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by samo on 2018/4/16.
 *
 * @author samo
 * @date 2018/04/16
 */
public class TestOperatorUtils {
    public static void main(String[] args) {
        Operator op;
        String[] types = new String[] {"say", "hear"};
        int random;
        for (int i = 0; i < 10; i++) {
            random = ThreadLocalRandom.current().nextInt(2);
            op = OperatorFactory.get(types[random]);
            if (op != null) {
                op.oper();
            }
        }
    }
}
