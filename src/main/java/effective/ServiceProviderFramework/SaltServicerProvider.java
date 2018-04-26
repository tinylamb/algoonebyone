package effective.ServiceProviderFramework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by samo on 2018/4/26.
 *
 * @author samo
 * @date 2018/04/26
 */
public class SaltServicerProvider {

    private static final Map<String, SaltServicer> SERVICER_PROVIDER = new ConcurrentHashMap<>();

    static {
        SERVICER_PROVIDER.put(SaltServicerType.BAY.getType(), BaySaltServicer.singleInstance());
        SERVICER_PROVIDER.put(SaltServicerType.INLAND.getType(), InlandSaltServicer.singleInstance());
    }

    public static SaltServicer getServicer(String type) {
        return SERVICER_PROVIDER.getOrDefault(type, null);
    }

    enum SaltServicerType {
        /**
         * Bay
         */
        BAY("bay"),

        /**
         * Inland
         */
        INLAND("inland");

        private String type;

        SaltServicerType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
