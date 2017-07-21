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
        testcurrentTime();
    }

    public static void addElem(final List<String> l) {
        l.add("x");
        l.add("y");
    }

    public static void testTimeInterval() {
        List<String> ls = new ArrayList<String>();
        ls.add("2017-04-15 10:23:25");
        ls.add("2017-04-15 23:18:45");
        ls.add("2017-04-15 10:36:21");
        ls.add("2017-04-15 10:27:21");
        ls.add("2017-04-15 09:29:27");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println( sdf.getTimeZone() );
        Date zero =  new Date(0);
        System.out.println("zero Date : " + sdf.format(zero));
        Date initT = BasicTimeService.transStringToDate(ls.get(0), sdf);
        if(initT == null) {
            System.out.println(ls.get(0));
            System.exit(-1);
        }
        Date maxT = initT;
        Date minT = initT;
        for(String tmp : ls) {
            Date tmpT = BasicTimeService.transStringToDate(tmp, sdf);
            if(tmpT == null) {
                continue;
            }
            if(tmpT.after(maxT)) {
                maxT = tmpT;
            }
            if(tmpT.before(minT)) {
                minT = tmpT;
            }
        }
        System.out.println("max : " + sdf.format(maxT));
        System.out.println("min : " + sdf.format(minT));
        long hours = (maxT.getTime() - minT.getTime()) / 1000 / 3600;
        System.out.println("hours : " + hours);

    }

    public static void testDateTrans() {
        String t = "2017-02-21 15:45:11";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  12小时制
        Date d = null;
        try {
            d = sdf.parse(t);
            String trans = sdf.format(d);
            System.out.println("hour type : "  + trans);
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

    public static void testcurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = df.format(new Date());
        if (now.compareTo("2017-08-17 18:40") < 0) {
            System.out.println("no ");
        } else {
            System.out.println(">");
        }
        System.out.println(now);
    }
}
