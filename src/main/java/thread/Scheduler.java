package thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Created by samo on 2018/5/4.
 *
 * @author samo
 * @date 2018/05/04
 */
public class Scheduler {
    static volatile int i = 0;
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1, namedThreadFactory);
        exec.scheduleAtFixedRate(
            new Runnable() {
                @Override
                public void run() {
                    i += 1;
                    System.out.println(System.currentTimeMillis() + " val " + i);
                    if (i == 3) {
                        LockSupport.park();
                        //try {
                        //    Thread.sleep(10000);
                        //} catch (InterruptedException e) {
                        //    e.printStackTrace();
                        //}
                    }
                }
            },0, 1, TimeUnit.MINUTES
        );
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }, "tname");
    }
}
