package thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by samo on 2017/8/29.
 *
 * @author samo
 * @date 2017/08/29
 */

public class CollectionVisibilityDemo {

    private static List<String> stopList = null;
    private static Map<String, String> stopMap = null;

    //private static volatile List<String> stopList = null;
    //private static volatile Map<String, String> stopMap = null;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 is started.");
                int i = 0;
                while (stopList == null || stopMap == null) {
                    i++;
                    //System.out.println("current i : " + i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Thread 1 is stop.");
            }
        });

        thread1.start();

        Thread.sleep(1000);
        stopList = new ArrayList<String>();
        stopMap = new HashMap<String, String>();

        System.out.println("Main thread is stop. The stopList is " + stopList + " and stopMap is " + stopMap);
    }
}

