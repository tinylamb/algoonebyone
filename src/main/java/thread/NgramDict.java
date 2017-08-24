package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by samo on 2017/8/20.
 *
 * @author samo
 * @date 2017/08/20
 */
public class NgramDict {
    /**
     *
     * If you're going to have threads reading from it while you are writing (updating the existing HashMap) then you should use a ConcurrentHashMap, yes.
     * If you are populating an entirely new HashMap then assigning it to the existing variable, then you use volatile
     */
    private volatile Map<String, String> freqWords;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //private Map<String, String> freqWords;

    public NgramDict() {
        //freqWords = new ConcurrentHashMap<String, String>();
        //freqWords = new HashMap<String, String>();
        freqWords = new HashMap<String, String>();
    }

    public void update() {
        //freqWords.put(String.valueOf(System.currentTimeMillis()),
        //    String.valueOf(System.currentTimeMillis()) );
        Map<String, String> result = randmap();
        if (result != null && !result.isEmpty()) {
            freqWords = result;
            System.out.println("new : " + freqWords);
        }
        //通过randmap修改引用
    }

    private Map<String, String> randmap() {
        Map<String, String> map = new HashMap<String, String>();
        int size = (int)(Math.random() * 20)+ 1;
        for (int i = 0; i < size; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        return map;
    }

    public Map<String, String> getFreqWords() {
        return freqWords;
    }

    public int getSize() {
        return freqWords.size();
    }

    public void updatengram() {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(
            new Runnable() {
                public void run() {
                    //System.out.println(System.currentTimeMillis() + " " + "update");
                    System.out.println(sdf.format(new Date()));
                }
            },1, 5, TimeUnit.SECONDS
        );
    }
}
