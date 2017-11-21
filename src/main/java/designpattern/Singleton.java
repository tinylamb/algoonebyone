package designpattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by samo on 2017/11/20.
 *
 * @author samo
 * @date 2017/11/20
 */
public class Singleton {
    private static int count;
    private Singleton() {
        System.out.println("Singleton 私有的构造方法被实例化 " + (++count) + " 次。");
    }

    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Singleton single = Singleton.getInstance();
                        Thread.sleep(10000);
                        System.out.println("single : " + single.hashCode());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}

