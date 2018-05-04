package thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by samo on 2018/5/2.
 *
 * @author samo
 * @date 2018/05/02
 */
public class TestLockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("current : " + i);
                    if (i == 5) {
                        LockSupport.park(this);
                    }
                }
            }
        }, "t1");

        t.start();
        try {
            Thread.sleep(8000);
            //LockSupport.unpark(t);
            t.interrupt();
            /**
             * 那是不是只有以上 3 种方法能自动感知到中断呢？
             * 不是的，如果线程阻塞在 LockSupport.park(Object obj) 方法，也叫挂起
             * 这个时候的中断也会导致线程唤醒，但是唤醒后不会重置中断状态，所以唤醒后去检测中断状态将是 true。
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
