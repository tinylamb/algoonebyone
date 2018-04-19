package generic;

/**
 * Created by samo on 2018/3/14.
 *
 * @author samo
 * @date 2018/03/14
 */
public class AbstractOperatorImplOne extends AbstractOperator {
    public AbstractOperatorImplOne() {
    }


    @Override
    public String join() {
        return getBasic() + "One";
    }

    @Override
    public boolean ICanOper(OperatorCheck data) {
        return "one".equals(data.getType());
    }
}
