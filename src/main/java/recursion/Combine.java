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
        //testcomb1();
        testcomb2();
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

    public static void testcomb1() {
        String[] arr = {"A","B","C","D","E","F"};
        int k = 2;
        combinations2(arr, k, 0, new String[k]);
    }

    public static void testcomb2() {
        String[] arr = {"A","B","C","D","E","F"};
        final List<String[]> ls = new ArrayList<String[]>();
        final int k = 2;
        combinations(arr, k, 0, new String[k], ls);
        System.out.println(ls.size());

        for (String[] tmp : ls ) {
            printStrarr(tmp);
        }
    }

    public static void printStrarr(String[] arr) {
        for (String tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void combinations2(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }

    public static void combinations(String[] arr, int len, int startPosition, String[] result, final List<String[]> comb){
        if (len == 0){
            comb.add(result.clone());
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations(arr, len-1, i+1, result, comb);
        }
    }
}
