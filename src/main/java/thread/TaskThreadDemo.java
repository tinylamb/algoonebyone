package thread;

/**
 * Created by samo on 2017/8/28.
 *
 * @author samo
 * @date 2017/08/28
 */
public class TaskThreadDemo {
    public static void main(String[] args) {
        Runnable printA = new PrintChar('A', 10);
        Runnable printB = new PrintChar('B', 10);
        Thread threadA = new Thread(printA);
        Thread threadB = new Thread(printB);
        Thread threadC = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.print('C');
                }
                System.out.println("C-thread");
            }
        };
        Thread threadD = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.print('D');
                    }
                    System.out.println("D-thread");
                }
            }
        );

        /**
         * run 顺序执行
         */
        //threadA.run();
        //threadB.run();
        //threadC.run();
        //threadD.run();
        /**
         * start 时间片执行
         */
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
