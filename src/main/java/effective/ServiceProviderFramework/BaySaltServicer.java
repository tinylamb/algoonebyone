package effective.ServiceProviderFramework;

/**
 * Created by samo on 2018/4/26.
 *
 * @author samo
 * @date 2018/04/26
 */
public class BaySaltServicer implements SaltServicer{
    @Override
    public Salt getSalt() {
        return new BaySalt();
    }

    private BaySaltServicer() {
    }


    public static BaySaltServicer singleInstance() {
        return Holder.baySaltServicer;
    }

    static class Holder {
        static BaySaltServicer baySaltServicer = new BaySaltServicer();
    }
}
