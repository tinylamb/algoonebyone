package thread.sharemem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by samo on 2018/4/30.
 *
 * @author samo
 * @date 2018/04/30
 */
public class Share {
    /*
     * ArrayList Exception in thread "read" java.util.ConcurrentModificationException
     */
    public static void main(String[] args) {
        final List<String> ls = new ArrayList<>(Arrays.asList("1", "2", "3"));
        //final List<String> ls = Collections.synchronizedList(new ArrayList<>(Arrays.asList("1", "2", "3")));
        Thread read = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ls) {
                    System.out.println("read " + ls);
                    for (String tmp : ls) {
                        System.out.print(tmp);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " end");
            }
        }, "read");
        Thread write = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                synchronized (ls) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i);
                        ls.add(String.valueOf(i));
                        try {
                            ls.wait();
                            //TODO wait without notify
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + " end");
            }
        },"write");
        read.start();
        write.start();
    }
}
