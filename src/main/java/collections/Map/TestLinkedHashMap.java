package collections.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by samo on 2018/4/20.
 *
 * @author samo
 * @date 2018/04/20
 */
public class TestLinkedHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("10", "10");
        map.put("1", "1");
        map.put("2", "2");
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println(String.format("key : %s , val : %s", entry.getKey(), entry.getValue()));
        }

        Map<String, String> hashmap = new HashMap<>(2);
        hashmap.put("10", "10");
        hashmap.put("1", "1");
        hashmap.put("2", "2");
        for (Entry<String, String> entry : hashmap.entrySet()) {
            System.out.println(String.format("key : %s , val : %s", entry.getKey(), entry.getValue()));
        }
    }
}
