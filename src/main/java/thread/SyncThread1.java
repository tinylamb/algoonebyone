package thread;

/**
 * Created by samo on 2018/4/14.
 *
 * @author samo
 * @date 2018/04/14
 */
public class SyncThread1 implements Runnable {
    private Integer key = 0;

    public SyncThread1() {
    }

    public SyncThread1(Integer key) {
        this.key = key;
    }

    @Override
    public void run() {
        // key是Integer对象（注意不是int，因为int不是对象）
        // 线程进入下面同步代码之前，需要先获取key的锁。
        // 需要结果是key实现自增长，如果没有同步块，则可能会出现重复key值的现象
        synchronized (key) {
            key++;

            System.out.println(Thread.currentThread().getName() + ":" + key);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        SyncThread1 st = new SyncThread1();

        for (int i = 0; i < 10; i++) {
            new Thread(st, "Thread" + i).start();
        }
    }
}
