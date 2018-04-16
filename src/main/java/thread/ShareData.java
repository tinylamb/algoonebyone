package thread;

/**
 * Created by samo on 2018/4/16.
 *
 * @author samo
 * @date 2018/04/16
 */
public class ShareData {
    //共享变量
    public static int count = 0;

    public static void addCount() {
        //互斥性
        count++;
    }

    public static synchronized void syncaddCount() {
        //原子性
        count++;
    }

    public static void main(String[] args) {
        ShareData sd = new ShareData();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                //private synchronized void addCount() {
                //    count++;
                //}
                @Override
                public void run() {
                    //进入sleep,增加并发出问题的概率
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 10; i++) {
                        ShareData.addCount();
                        //ShareData.syncaddCount();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count " + count);
    }
}
