package effective.singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by samo on 2018/4/29.
 *
 * @author samo
 * @date 2018/04/29
 */
public class ThreadWithSingleton {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String tname = Thread.currentThread().getName();
                SimpleSingleton singleton = SimpleSingleton.getInstance();
                System.out.println(tname + " singleton hash " + singleton.hashCode());
                List<String> ls = new ArrayList<>(Arrays.asList("1", "2", "3" ,"4", "5"));
                System.out.println(tname + " ls hash " + ls.hashCode());
                singleton.process(ls);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                singleton.process(ls);
            }
        }, "t1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String tname = Thread.currentThread().getName();
                SimpleSingleton singleton = SimpleSingleton.getInstance();
                System.out.println(tname + " singleton hash " + singleton.hashCode());
                List<String> ls = new ArrayList<>(Arrays.asList("A", "B", "C"));
                System.out.println(tname + " ls hash " + ls.hashCode());
                singleton.process(ls);
            }
        }, "t2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SimpleSingleton singleton = SimpleSingleton.getInstance();
                while (singleton.getStore().size() < 100) {
                    singleton.readStore();
                }
            }
        }, "t3");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleSingleton singleton = SimpleSingleton.getInstance();
        System.out.println(singleton.getStore());

    }
}
