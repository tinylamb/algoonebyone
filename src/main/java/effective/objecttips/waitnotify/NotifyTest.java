package effective.objecttips.waitnotify;

/**
 * Created by samo on 2018/4/28.
 *
 * @author samo
 * @date 2018/04/28
 */
public class NotifyTest {
    //private String flag = "true";
    private final String flag[] = {"true"};

    class NotifyThread extends Thread {
        public NotifyThread(String name) {
            super(name);
        }

        public void run() {
            try {
                sleep(3000);//推迟3秒钟通知
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (flag) {
                flag[0] = "false";
                //flag.notify();
                flag.notifyAll();
            }
        }
    }

    ;

    class WaitThread extends Thread {
        public WaitThread(String name) {
            super(name);
        }

        public void run() {
            synchronized (flag) {
                while (!flag[0].equals("false")) {
                    System.out.println(getName() + " begin waiting!");
                    long waitTime = System.currentTimeMillis();
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        System.out.println("i am interupted");
                        if (Thread.interrupted()) {
                            System.out.println("");
                        } else {
                            System.out.println("set interupt false");
                        }
                        //e.printStackTrace();
                    }
                    waitTime = System.currentTimeMillis() - waitTime;
                    System.out.println(getName() + " wait time :" + waitTime);
                }
                System.out.println(getName() + " end waiting!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Run!");
        NotifyTest test = new NotifyTest();
        NotifyThread notifyThread = test.new NotifyThread("notify01");
        WaitThread waitThread01 = test.new WaitThread("waiter01");
        WaitThread waitThread02 = test.new WaitThread("waiter02");
        WaitThread waitThread03 = test.new WaitThread("waiter03");
        notifyThread.start();
        waitThread01.start();
        waitThread02.start();
        waitThread03.start();
        //waitThread03.interrupt();
    }

}

/**
 * 任何一个时刻，对象的控制权（monitor）只能被一个线程拥有。
 无论是执行对象的wait、notify还是notifyAll方法，必须保证当前运行的线程取得了该对象的控制权（monitor）
 如果在没有控制权的线程里执行对象的以上三种方法，就会报java.lang.IllegalMonitorStateException异常。
 JVM基于多线程，默认情况下不能保证运行时线程的时序性

 */

/**所以尽量obj是final
 * 这时的异常是由于在针对flag对象同步块中，更改了flag对象的状态所导致的。如下：

 flag="false";

 flag.notify();

 对在同步块中对flag进行了赋值操作，使得flag引用的对象改变，这时候再调用notify方法时，因为没有控制权所以抛出异常。
 */
