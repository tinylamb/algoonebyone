package generic;

/**
 * Created by samo on 2018/3/13.
 *
 * @author samo
 * @date 2018/03/13
 */
public class BOperator implements Operator<String>{
    public static final String OPERATOR_NAME = "B";
    @Override
    public String compute(String input) {
        return input.concat("haha");
    }
}
