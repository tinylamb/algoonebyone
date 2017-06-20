package basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by samo on 2017/6/15.
 *
 * @author samo
 * @date 2017/06/15
 */
public class Clone {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        ls.add("A");
        ls.add("B");
        ls.add("C");
        Iterator<String> it = ls.iterator();
        List<String> newls = new ArrayList<String>();
        while (it.hasNext()) {
            newls.add(it.next());
        }
        for (String s : newls) {
            System.out.println(s);
        }
    }
}
