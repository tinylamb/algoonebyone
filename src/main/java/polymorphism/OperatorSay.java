package polymorphism;

/**
 * Created by samo on 2018/4/16.
 *
 * @author samo
 * @date 2018/04/16
 */
public class OperatorSay implements Operator {

    //public static OperatorName NAME = OperatorName.SAY;

    private OperatorSay() {
        //TODO 初始化线程池
        System.out.println("init " + this.getClass().getName());
    }

    private static Operator op = new OperatorSay();

    public static Operator getOperator() {
        return op;
    }

    @Override
    public void oper() {
        System.out.println("I can Say");
    }
}
