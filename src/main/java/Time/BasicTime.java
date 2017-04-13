package Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by samo on 2017/4/13.
 *
 * @author samo
 * @date 2017/04/13
 */
public class BasicTime {

    public static void main(String[] args) {
        String t = "2017-02-21 01:45:11";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d = null;
        try {
            d = sdf.parse(t);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // date.getTime()所返回的是一个long型的毫秒数
        //System.out.println(d.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.HOUR, 1);
        int minadd = 60 - c.get(Calendar.MINUTE);
        c.add(Calendar.MINUTE, minadd);
        Date nd = c.getTime();
        String trans = sdf.format(nd);
        System.out.println(trans);

        final List<String> ls = new ArrayList<String>();
        ls.add("a");
        addElem(ls);
        System.out.println(ls);

        double a = 2.4;
        int h = (int)a;
        System.out.println(h);
        int dmin = (int)((a - h) * 60);
        System.out.println(dmin);

    }

    public static void addElem(final List<String> l) {
        l.add("x");
        l.add("y");
    }
}
