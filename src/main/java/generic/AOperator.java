package generic;

/**
 * Created by samo on 2018/3/13.
 *
 * @author samo
 * @date 2018/03/13
 */
public class AOperator implements Operator {
    public static final String OPERATOR_NAME = "A";
    @Override
    public String compute(Object input) {
        return (String)input;
    }
}
