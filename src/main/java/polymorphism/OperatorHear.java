package polymorphism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Created by samo on 2018/4/16.
 *
 * @author samo
 * @date 2018/04/16
 */
public class OperatorHear implements Operator {

    private ExecutorService executor;

    private OperatorHear() {
        //ThreadFactory threadFactory = new ThreadFactory() {
        //    private int i = 0;
        //    public Thread newThread(Runnable r) {
        //        return new Thread(r, "Delivery-Manager-" + this.i++);
        //    }
        //};
        ThreadFactory tf = new ThreadFactoryBuilder().setNameFormat("LocalJobRunner Task Executor #%d").build();
        System.out.println("init " + this.getClass().getName());
        executor = Executors.newCachedThreadPool(tf);
    }

    private static OperatorHear op = new OperatorHear();

    public static Operator getOperator() {
        return op;
    }

    @Override
    public void oper() {
        System.out.println("I can Hear");
        for (int i = 0; i < 10; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("I can Hear thread");
                }
            });
        }
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }
}
