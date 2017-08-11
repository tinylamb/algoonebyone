package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by samo on 2017/8/8.
 *
 * @author samo
 * @date 2017/08/08
 */
public class Combine {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList(new String[]{"a", "b", "c", "d", "e"});
        System.out.println(ls.subList(0, ls.size() - 1));
        List<String> com = new ArrayList<String>();
        com = combineElems(ls, 2);
        System.out.println(com);
    }

    public static List<String> combineElems(List<String> ls, int k) {
        if (ls.size() == k) {
            return ls;
        } else {
            //1. keep elem
            String elem = ls.get(ls.size() - 1);
            List<String> subls = ls.subList(0, ls.size() - 1);
            List<String> sub = combineElems(subls, k - 1);
            List<String> r1 = new ArrayList<String>();
            for (String tmp : sub) {
                r1.add(tmp + "#" + elem);
            }
            List<String> r2 = combineElems(subls, k);
            //List<String> result = new ArrayList<String>();
            r1.addAll(r2);
            return r1;
        }
    }
}
