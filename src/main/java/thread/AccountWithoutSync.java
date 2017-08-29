package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by samo on 2017/8/29.
 *
 * @author samo
 * @date 2017/08/29
 */
public class AccountWithoutSync {
    private static Account account = new Account();

    private static class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public synchronized void deposit(int amount) {
            //balance = balance + amount;
            int newBalance = balance + amount;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            balance = newBalance;
        }

        public void depositwithnosync(int amount) {
            //balance = balance + amount;
            int newBalance = balance + amount;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            balance = newBalance;
        }
    }

    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.depositwithnosync(1);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        //ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("What is balance? " + account.getBalance());
    }
}
