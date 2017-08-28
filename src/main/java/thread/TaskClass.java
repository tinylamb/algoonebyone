package thread;

/**
 * Created by samo on 2017/8/28.
 *
 * @author samo
 * @date 2017/08/28
 */
public class TaskClass implements Runnable {

    public TaskClass() {
    }

    @Override
    public void run() {
        ;
    }

    public static void main(String[] args) {
        TaskClass task = new TaskClass();
        Thread thread = new Thread(task);
        thread.start();
    }
}
