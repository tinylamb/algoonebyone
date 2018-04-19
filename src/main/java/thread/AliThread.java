package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Created by samo on 2018/4/17.
 *
 * @author samo
 * @date 2018/04/17
 */
public class AliThread {
    /**
     * 深度解读 java 线程池设计思想及源码实现
     * https://javadoop.com/post/java-thread-pool
     *
     * 线程池的创建---ThreadPoolExecutor
     * https://www.jianshu.com/p/0e228dc30793
     */
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


        //pool.execute(()-> System.out.println(Thread.currentThread().getName()));

        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        pool.shutdown();//gracefully shutdown

    }
}
