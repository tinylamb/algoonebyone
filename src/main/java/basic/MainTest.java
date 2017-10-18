package basic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by samo on 2017/4/20.
 *
 * @author samo
 * @date 2017/04/20
 */
public class MainTest {

    public static String getVerionByPath(String file) {
        if (file != null && file.length() > 0 && StringUtils.contains(file, ".jar")) {
            int index = StringUtils.lastIndexOf(file, ".jar");
            file = file.substring(0, index);
            int i = file.lastIndexOf('/');
            if (i >= 0) {
                file = file.substring(i + 1);
            }
            i = file.indexOf("-");
            if (i >= 0) {
                file = file.substring(i + 1);
            }
            while (file.length() > 0 && !Character.isDigit(file.charAt(0))) {
                i = file.indexOf("-");
                if (i >= 0) {
                    file = file.substring(i + 1);
                } else {
                    break;
                }
            }
            return file;
        } else {
            return null;
        }
    }

    public static void testgetVerionByPath() {
        System.out.println(getVerionByPath("onlinerobotunknownissuemonitor-1.0-jar-with-dependencies.jar"));
    }

    public static void testLs() {
        List<String> ls = new ArrayList<>();
        ls.add(3, "a");
        for(String tmp : ls) {
            if(StringUtils.isEmpty(tmp)) {
                System.out.println("empty");
            } else {
                System.out.println(tmp);
            }
        }
    }

    public static void testObject() {
        Object obj = new Samo();
        ((Samo) obj).sayHi();
    }

    private static boolean checkVersionNecessary(String versionStr) {
        return !(versionStr == null || StringUtils.contains(versionStr, "with-dependencies")
            || StringUtils.contains(versionStr, "storm") || StringUtils.contains(versionStr, "odps"));
    }

    public static void testcheckVersionNecessary() {
        if (checkVersionNecessary("1.0-jar-with-dependencies")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void testDouble() {
        Double d = 0.123;
        String v = new DecimalFormat("0.00000000").format(d);
        System.out.println(v);
    }

    public static void testInteger() {
        Integer i = 1;
    }

    public static void testSplit() {
        String s = "a|b";
        String[] l1 = s.split("|");
        String[] l2 = StringUtils.split(s, "|");
        printArr(l1);
        printArr(l2);
    }

    public static <T> void printArr(T[] arr) {
        for (T tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void testInteger(Integer i) {
        i = 3;
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

    public static void testcombine() {
        String[] initwords = {"今天", "是", "个", "好日子"};
        final List<String[]> group3 = new ArrayList<String[]>();
        final int k3 = 3;
        combinations(initwords, k3, 0, new String[k3], group3);
        for (String[] tmp : group3) {
            printArr(tmp);
        }
    }



    public static void main(String[] args) {
        if ("showtypevalue卢林春".contains("showtypevalue")) {
            System.out.println("yes");
        }
    }
}
