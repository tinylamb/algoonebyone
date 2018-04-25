package thread;

import java.util.concurrent.Executor;

/**
 * Created by samo on 2018/4/22.
 *
 * @author samo
 * @date 2018/04/22
 */
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

    public static void main(String[] args) {
        ThreadPerTaskExecutor exe = new ThreadPerTaskExecutor();
        exe.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("start ran");
            }
        });
        System.out.println("main");
    }
}
