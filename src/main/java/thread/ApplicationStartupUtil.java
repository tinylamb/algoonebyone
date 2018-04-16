package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by samo on 2018/4/15.
 *
 * @author samo
 * @date 2018/04/15
 */
public class ApplicationStartupUtil {
    public static void main(String[] args) {
        CountDownLatch _latch = new CountDownLatch(2);

        List<BaseHealthChecker> _services = new ArrayList<>();
        _services.add(new NetworkHealthChecker(_latch));
        _services.add(new CacheHealthChecker(_latch));

        ExecutorService executor = Executors.newFixedThreadPool(_services.size());
        for (final BaseHealthChecker v : _services) {
            executor.submit(v);
        }
        try {
            _latch.await();
            for (final BaseHealthChecker v : _services) {
                if (v.is_serviceUp()) {
                    System.out.println(v.get_serviceName() + " is over");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}
