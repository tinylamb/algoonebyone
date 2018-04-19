package polymorphism;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samo on 2018/4/16.
 *
 * @author samo
 * @date 2018/04/16
 */
public class OperatorFactory {

    static enum OperatorName {
        SAY("say"), HEAR("hear");
        private String type;
        OperatorName(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
    }

    private static final Map<String, Operator> INSTANCE_MAP = new HashMap<>();
    static {
        INSTANCE_MAP.put(OperatorName.SAY.getType(), OperatorHear.getOperator());
        INSTANCE_MAP.put(OperatorName.HEAR.getType(), OperatorSay.getOperator());
    }

    public static Operator get(String type) {
        return INSTANCE_MAP.getOrDefault(type, null);
    }



}
