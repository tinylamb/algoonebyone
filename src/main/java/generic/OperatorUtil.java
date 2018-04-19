package generic;

import java.util.HashMap;
import java.util.Map;

import generic.AbstractOperator.OperatorCheck;

/**
 * Created by samo on 2018/3/13.
 *
 * @author samo
 * @date 2018/03/13
 */
public class OperatorUtil {
    private static final Map<String, String> INSTANCE_MAP = new HashMap<String, String>();
    static {
        INSTANCE_MAP.put(AOperator.OPERATOR_NAME, "generic.AOperator");
        INSTANCE_MAP.put(BOperator.OPERATOR_NAME, "generic.BOperator");
    }
    public static Operator getOperator(String type) {
        String classname = INSTANCE_MAP.get(type);
        if (classname == null) {
            return null;
        }
        try {
            return (Operator)Class.forName(classname).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String type = "B";
        Operator op = OperatorUtil.getOperator(type);
        if (op != null) {
            @SuppressWarnings("unchecked")
            String result = op.compute("input data");
            System.out.println(result);
        }

        AbstractOperator.OperatorCheck check = new OperatorCheck();
        check.setType("one");
        AbstractOperatorImplOne one = new AbstractOperatorImplOne();
        if (one.ICanOper(check)) {
            System.out.println("i can oper");
        }


    }
}
