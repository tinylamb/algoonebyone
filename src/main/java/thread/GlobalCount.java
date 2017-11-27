package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by samo on 2017/11/27.
 * https://stackoverflow.com/questions/2120248/how-to-synchronize-a-static-variable-among-threads-running-different-instances-o
 *
 * https://stackoverflow.com/questions/2423622/volatile-vs-static-in-java
 * @author samo
 * @date 2017/11/27
 */
public class GlobalCount {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadCount tc = new ThreadCount();
            tc.start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("GlobalCount cnt : " + ThreadCount.cnt);
    }
}

class ThreadCount extends Thread {

    private final static AtomicInteger count = new AtomicInteger(0);
    public static Integer cnt = 0;
    private static final Object countLock = new Object();
    //volatile 没用

    private void addOneee() {
        cnt++;
    }

    public static synchronized void addOne() {
        cnt++;
    }
    public void incrementCount() {
        synchronized (ThreadCount.class) {
            cnt++;
        }
    }

    public void addOnee() {
        synchronized (countLock) {
            cnt++;
        }
    }

    @Override
    public void run() {

        System.out.println ("Thread " +
            Thread.currentThread().getId() +
            " is running");
        for (int i = 0; i < 10; i++) {
            try {
                sleep(100);
                //cnt++;
                addOnee();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("ThreadCount cnt : " + cnt);
    }
}
