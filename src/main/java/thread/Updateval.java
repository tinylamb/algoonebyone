package thread;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samo on 2017/8/20.
 *
 * @author samo
 * @date 2017/08/20
 */
public class Updateval {
    public volatile static Map<String, String> val = new HashMap<String, String>();
    //ConcurrentModificationException
    //public static Map<String, String> val = new ConcurrentHashMap<String, String>();

    public static NgramDict dict = new NgramDict();

    private static void updateDict() {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    //val.put(String.valueOf(System.currentTimeMillis()),
                    //    String.valueOf(System.currentTimeMillis()));
                    dict.update();
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        updateDict();
        int i = 0;
        while (i < 1000) {
            System.out.println("main " + i + " " + dict.getSize()  + " " + dict.getFreqWords());
            //System.out.println(i + " " + val.size()  + " " + val);
            i++;
        }
    }
}
