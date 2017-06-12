package challenges.array_string;

/**
 * Created by samo on 2017/4/25.
 *
 * @author samo
 * @date 2017/04/25
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a hash table with set, get, and remove methods
 */
public class HashTable {

    //二维数组
    private final int KEY = 5;
    private int size;
    private String[][] table;

    public HashTable(int size) {
        this.size = size;
        this.table = new String[KEY][size];
    }

    private int BKDRHash(final String val) {
        //char[] cArr = val.toCharArray();
        int seed = 131;
        int hash = 0;
        for (int i = 0; i < val.length(); i++) {
            hash = seed * hash + val.charAt(i);
        }
        return hash % KEY;
    }

    public void setVal(final String val) {
        int hashval = BKDRHash(val);
        String[] store = table[hashval];
        int i = 0;
        for (; i < store.length; i++) {
            if(val.equals(store[i])) {
                System.out.println("exsits val : " + val + " , key : " + hashval + " index : " + i);
                break;
            }
            if(store[i] == null) {
                store[i] = val;
                System.out.println("set val : " + val + " , key : " + hashval + " index : " + i);
                break;
            }
        }
        if (i == store.length) {
            System.out.println("full, can not set val : " + val);
        }
    }

    public boolean getVal(final String val) {
        int hashval = BKDRHash(val);
        String[] store = table[hashval];
        int i = 0;
        for (; i < store.length; i++) {
            if (val.equals(store[i])) {
                System.out.println("find val : " + val + " , key : " + hashval + " index : " + i);
                return true;
            }
        }
        if(i == store.length) {
            System.out.println("not find");
        }
        return false;
    }

    public boolean mvVal(final String val) {
        int hashval = BKDRHash(val);
        String[] store = table[hashval];
        int i = 0;
        for (; i < store.length; i++) {
            if (store[i].equals(val)) {
                System.out.println("mv " + val + " key : " + hashval + " index : " + i);
                store[i] = null;
                return true;
            }
        }
        if(i == store.length) {
            System.out.println("not find");
        }
        return false;
    }

    public static void testTwoDArray() {
        int[][] array1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };

        int[][] array2 = new int[3][];
        array2[0] = new int[5];
        array2[1] = new int[4];
        array2[2] = new int[3];

        String[][] str = new String[2][3];
        for (String[] tmp : str) {
            // len 3
            System.out.println(tmp.length);
            for (String tmp2 : tmp) {
                //null
                System.out.println(tmp2);
            }
        }
    }

    public static void testHash() {
        HashTable t = new HashTable(1);
        t.setVal("a");
        t.setVal("b");
        t.setVal("c");
        t.setVal("d");
        t.setVal("e");
        t.setVal("f");
        t.setVal("g");
        t.setVal("a");
        t.getVal("a");
    }

    public static void testNull() {
        String s = null;
        if(s instanceof String ) {
            System.out.println("is String");
        } else {
            System.out.println("not String");
        }

    }

    public static void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("语文", "yuwen");

    }

    public static void main(String[] args) {

        testHash();

    }
}
