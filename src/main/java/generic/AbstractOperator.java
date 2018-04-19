package generic;

/**
 * Created by samo on 2018/3/14.
 *
 * @author samo
 * @date 2018/03/14
 */
public abstract class AbstractOperator implements Operator<String> {

    private String basic;

    @Override
    public String compute(String input) {
        return join();
    }

    public abstract String join();

    public abstract boolean ICanOper(OperatorCheck data);

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public static class OperatorCheck {
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
