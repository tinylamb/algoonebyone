package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by samo on 2018/4/15.
 *
 * @author samo
 * @date 2018/04/15
 */
public class NetworkHealthChecker extends BaseHealthChecker {
    public NetworkHealthChecker (CountDownLatch latch)  {
        super("Network Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.get_serviceName());
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.get_serviceName() + " is UP");
    }
}
