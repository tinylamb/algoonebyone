package thread;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import learnclass.AbstractHouse;
import learnclass.AbstractHouseImp;

/**
 * Created by samo on 2018/4/22.
 *
 * @author samo
 * @date 2018/04/22
 */
public class DirectExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        DirectExecutor exe = new DirectExecutor();
        exe.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("i am runnable");
            }
        });

        AbstractExecutorService aes = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

        AbstractHouse abstractHouse = new AbstractHouseImp();
        //abstractHouse.price() 必须在同一个package才能被访问

        final int RUNNING    = -1 << 29;
        System.out.println(RUNNING);
    }
}
