package thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/**
 * Created by samo on 2018/4/22.
 *
 * @author samo
 * @date 2018/04/22
 */
public class SerialExecutor implements Executor {
    //任务队列
    final Queue<Runnable> tasks = new ArrayDeque<>();

    //真正的执行器(调度?)
    final Executor executor;

    //当前正在执行的任务
    Runnable active;

    public SerialExecutor(Executor executor) {
        this.executor = executor;
    }

    //将任务添加到任务队列，scheduleNext 触发执行器去任务队列取任务
    public synchronized void execute(final Runnable r) {
        tasks.offer(new Runnable() {
            public void run() {
                try {
                    r.run();
                } finally {
                    scheduleNext();
                }
            }
        });
        if (active == null) {
            scheduleNext();
        }
    }

    protected synchronized void scheduleNext() {
        if ((active = tasks.poll()) != null) {
            // 具体的执行转给真正的执行器 executor
            executor.execute(active);
        }
    }

    //@Override
    //public void execute(Runnable command) {
    //
    //}
}
