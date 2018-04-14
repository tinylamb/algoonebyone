package thread;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by samo on 2018/4/14.
 *
 * @author samo
 * @date 2018/04/14
 */
public class Findmax {
    public static void main(String[] args) {
        testInteger();
    }

    public static void testInteger() {
        //Integer is immutable
        Integer max = 0;
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(new MaxJob(i, max));
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                System.out.println("executor finish");
                //max = 101; if max is final error
                System.out.println("final max Integer :" + max);
                break;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void testAtomicInteger() {
        AtomicInteger max = new AtomicInteger(-1);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(new MaxJob(i, max));
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                System.out.println("executor finish");
                System.out.println("final max AtomicInteger :" + max);
                break;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void testConcurrentHashMap() {
        final Map<String, Integer> max = new ConcurrentHashMap<>();
        max.put("max", 1);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(new MaxJob(i, max));
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                System.out.println("executor finish");
                System.out.println("final max Map:" + max);
                break;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MaxJob implements Runnable {
        private int id;
        private Map<String, Integer> max;
        private AtomicInteger integer;
        private Integer val;

        public MaxJob() {
        }

        public MaxJob(int id, final Map<String, Integer> max) {
            this.id = id;
            this.max = max;
            this.integer = new AtomicInteger(0);
        }

        public MaxJob(int id, final AtomicInteger number) {
            this.id = id;
            this.integer = number;
            this.max = new HashMap<>();
        }

        public MaxJob(int id, Integer val) {
            this.id = id;
            this.val = val;
            this.integer = new AtomicInteger(0);
            this.max = new HashMap<>();
        }

        @Override
        public void run() {
            Integer random = ThreadLocalRandom.current().nextInt(100);
            System.out.println(id + " random : " + random);
            if (random > max.getOrDefault("max", 1)) {
                max.put("max", random);
            }
            if (random > integer.intValue()) {
                integer.set(random);
            }
            synchronized (val) {
                if (random > val) {
                    try {
                        Field valueField = Integer.class.getDeclaredField("value");
                        valueField.setAccessible(true);
                        int tempAValue = valueField.getInt(val);
                        valueField.setInt(val, random.intValue());
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            //if (random > val) {
            //    synchronized (val) {
            //        try {
            //            Field valueField = Integer.class.getDeclaredField("value");
            //            valueField.setAccessible(true);
            //            int tempAValue = valueField.getInt(val);
            //            valueField.setInt(val, random.intValue());
            //        } catch (NoSuchFieldException e) {
            //            e.printStackTrace();
            //        } catch (IllegalAccessException e) {
            //            e.printStackTrace();
            //        }
            //    }
            //}
            //Integer random = (int)ThreadLocalRandom.current().nextDouble() * 100;
        }
    }

}

