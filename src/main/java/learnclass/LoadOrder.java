package learnclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by samo on 2017/12/13.
 *
 * @author samo
 * @date 2017/12/13
 */
public class LoadOrder {

    public static void hello() {
        System.out.println("hello");
    }

    static {
        System.out.println("1");
    }

    public static void main(String[] args) {
        testdeepcopy();
    }

    public static void testcopy() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> ls = new ArrayList<>();
        ls.add("1");
        map.put("1", ls);
        Map<String, List<String>> map2 = copy(map);
        System.out.println(map2);
        ls.add("22");
        System.out.println(map2);
    }

    public static Map<String, List<String>> copy(Map<String, List<String>> map) {
        Map<String, List<String>> v = new HashMap<>();
        for (Entry<String, List<String>> tmp : map.entrySet()) {
            v.put(tmp.getKey(), new ArrayList<>(tmp.getValue()));
            //v.put(tmp.getKey(), tmp.getValue());
        }
        return v;

    }

    public Map<String, Map<String, Double[]>> copyAggtime() {
        Map<String, Map<String, Double[]>> agg = new HashMap<>();

        return null;
    }

    public static void testmapcopy() {
        // create two hash maps
        HashMap newmap1 = new HashMap();
        HashMap newmap2 = new HashMap();

        // populate 1st map
        newmap1.put(1, "tutorials");
        newmap1.put(2, "point");
        newmap1.put(3, "is best");

        // clone 1st map
        newmap2 = (HashMap)newmap1.clone();

        System.out.println("1st Map: " + newmap1);
        System.out.println("Cloned 2nd Map: " + newmap2);
    }

    public static void testdeepcopy() {
        //浅拷贝与深拷贝
        //浅拷贝:被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。
        //换言之，浅复制仅仅复制所考虑的对象，而不复制它所引用的对象。
        //深拷贝：被复制对象的所有变量都含有与原来的对象相同的值，除去那些引用其他对象的变量。
        //那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。
        //换言之，深复制把要复制的对象所引用的对象都复制了一遍。
        //1、直接赋值（字符串外都属于浅拷贝）
        //2、使用构造函数（深拷贝）
        //3、使用clone()方法（深拷贝）

        //字符串(不理解无colne()方法)
        String s = "sss";
        String t = s;   //深拷贝
        String y = new String(s); //深拷贝
        System.out.println("s:" + s + " t:" + t + " y:" + y);
        t = "ttt";
        y = "yyy";
        System.out.println("s:" + s + " t:" + t + " y:" + y);

        //数组
        String[] ss = {"111", "222", "333"};
        String[] tt = ss; //浅拷贝
        String[] ww = (String[])ss.clone();//深拷贝
        System.out.println("ss:" + ss[1] + " tt:" + tt[1] + " ww:" + ww[1]);
        tt[1] = "2t2";
        ww[1] = "2w2";
        System.out.println("ss:" + ss[1] + " tt:" + tt[1] + " ww:" + ww[1]);

        //list列表
        ArrayList a = new ArrayList();
        for (int i = 0; i < 10; i++) {
            a.add(String.valueOf(i + 1));
        }
        ArrayList b = a;//浅拷贝
        ArrayList c = new ArrayList(a);//深拷贝
        ArrayList d = (ArrayList)a.clone();//深拷贝
        System.out.println("a:" + a.get(1) + " b:" + b.get(1) + " c:" + c.get(1) + " d:" + d.get(1));
        b.set(1, "bbb");
        c.set(1, "ccc");
        System.out.println("a:" + a.get(1) + " b:" + b.get(1) + " c:" + c.get(1) + " d:" + d.get(1));

        //HashMap
        HashMap h = new HashMap();
        h.put("1", "hhh");
        HashMap m = h;//浅拷贝
        HashMap p = new HashMap(h);//深拷贝
        HashMap n = (HashMap)h.clone();//深拷贝
        System.out.println("h:" + h.get("1") + " m:" + m.get("1") + " p:" + p.get("1") + " n:" + n.get("1"));
        m.put("1", "mmm");
        p.put("1", "ppp");
        n.put("1", "nnn");
        System.out.println("h:" + h.get("1") + " m:" + m.get("1") + " p:" + p.get("1") + " n:" + n.get("1"));
    }

}
