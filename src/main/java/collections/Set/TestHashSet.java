package collections.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by samo on 2018/4/21.
 *
 * @author samo
 * @date 2018/04/21
 */
public class TestHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        if (!set.add("1")) {
            //Map put : previous value, or null if none
            System.out.println("already have");
        }
        Set<String> s2;
        if ((s2 = set) != null) {
            System.out.println(s2);
        }
        System.out.println(set);
    }
}
