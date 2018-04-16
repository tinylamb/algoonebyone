package thread;

/**
 * Created by samo on 2018/4/16.
 *
 * @author samo
 * @date 2018/04/16
 */
public class VisibilityTest {
    //可见性 线程的JVM模型
    //还有指令的顺序性 编译器优化的重排序。编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序
    //refer http://www.cnblogs.com/paddix/p/5374810.html
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!ready) {
                System.out.println("ready " + ready);
            }
            System.out.println("number " + number);
        }
    }

    private static class WriterThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number = 1024;
            ready = true;
        }
    }

    public static void main(String[] args) {
        new WriterThread().start();
        new ReaderThread().start();
    }

}
