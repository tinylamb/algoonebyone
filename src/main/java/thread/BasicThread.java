package thread;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by samo on 2017/7/28.
 *
 * @author samo
 * @date 2017/07/28
 */
public class BasicThread extends Thread {

    private static long sleept = 5 * 1000;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("hello world " + df.format(new Date()));
                sleep(sleept);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void run(int i) {
        while (true) {
            try {
                System.out.println("one piece " + df.format(new Date()));
                sleep(sleept);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void testrun() {
        BasicThread t = new BasicThread();
        t.start();
        t.run(1); //faild if Thread t = new BasicThread()
    }

    private static void testgetDeclaredMethods() {
        System.out.println("getDeclaredMethods");
    }

    public static void testreflect() {
        ClassLoader loader = thread.BasicThread.class.getClassLoader();
        ClassLoader loader1 = Thread.currentThread().getContextClassLoader();
        try {
            Class cl = loader1.loadClass("thread.BasicThread");
            Object ob = cl.newInstance();
            Method[] ms = cl.getDeclaredMethods();
            for (Method m : ms) {
                System.out.println(m.toString());
            }
            Method run1 = cl.getDeclaredMethod("run", int.class);
            run1.invoke(ob, 1);

            Method run2 = cl.getDeclaredMethod("run");
            run2.invoke(cl.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testreflect();


        //Thread t = new Thread() {
        //    @Override
        //    public void run() {
        //        while (true) {
        //            try {
        //                System.out.println("hello world " + df.format(new Date()));
        //                sleep(sleept);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //                break;
        //            }
        //        }
        //    }
        //};
        //t.start();

        //Thread t2 = new Thread() {
        //    public void runy(int l) {
        //        while (true) {
        //            try {
        //                System.out.println("one piece " + df.format(new Date()));
        //                sleep(sleept);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //                break;
        //            }
        //        }
        //    }
        //};
    }
}
