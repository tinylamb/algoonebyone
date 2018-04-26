package effective.ServiceProviderFramework;

/**
 * Created by samo on 2018/4/26.
 *
 * @author samo
 * @date 2018/04/26
 */
public class TestFW {
    public static void main(String[] args) {
        SaltServicer servicer = SaltServicerProvider.getServicer("bay");
        if (servicer == null) {
            System.out.println("undefined server");
            System.exit(0);
        }
        servicer.getSalt().addI();
    }
}
