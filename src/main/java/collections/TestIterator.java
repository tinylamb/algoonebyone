package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by samo on 2017/11/29.
 *
 * @author samo
 * @date 2017/11/29
 */
public class TestIterator {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>(16);
        collection.add("1");
        collection.add("2");
        collection.add("3");
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (String tmp : collection) {
            System.out.println(tmp);
        }
    }
}
