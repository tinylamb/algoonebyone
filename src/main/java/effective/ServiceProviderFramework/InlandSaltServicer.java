package effective.ServiceProviderFramework;

/**
 * Created by samo on 2018/4/26.
 *
 * @author samo
 * @date 2018/04/26
 */
public class InlandSaltServicer implements SaltServicer{
    @Override
    public Salt getSalt() {
        return new InlandSalt();
    }

    private InlandSaltServicer() {
    }

    public static InlandSaltServicer singleInstance() {
        return Holder.inlandSaltServicer;
    }

    static class Holder {
        static InlandSaltServicer inlandSaltServicer = new InlandSaltServicer();
    }
}
