package effective.objecttips.waitnotify;

/**
 * Created by samo on 2018/4/28.
 *
 * @author samo
 * @date 2018/04/28
 */
public class WaitNotify {

    public static void main(String[] args) {

        final Object object = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //--这里sleep会导致 wait后，没有nofity了
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //--
                synchronized (object) {
                    System.out.println("线程1 获取到监视器锁");
                    try {
                        // 感觉wait要配置条件判断使用
                        object.wait();
                        System.out.println("线程1 恢复啦。我为什么这么久才恢复，因为notify方法虽然早就发生了，可是我还要获取锁才能继续执行。");
                    } catch (InterruptedException e) {
                        System.out.println("线程1 wait方法抛出了InterruptedException异常");
                    }
                }
            }
        }, "线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程2 拿到了监视器锁。为什么呢，因为线程1 在 wait 方法的时候会自动释放锁");
                    System.out.println("线程2 执行 notify 操作");
                    object.notify();
                    System.out.println("线程2 执行完了 notify，先休息3秒再说。");
                    try {
                        Thread.sleep(3000);
                        System.out.println("线程2 休息完啦。注意了，调sleep方法和wait方法不一样，不会释放监视器锁");
                    } catch (InterruptedException e) {

                    }
                    System.out.println("线程2 休息够了，结束操作");
                }
            }
        }, "线程2").start();
    }
}
