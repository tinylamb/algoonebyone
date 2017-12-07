package basic;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by samo on 2017/8/18.
 *
 * @author samo
 * @date 2017/08/18
 */
public class Test {
    public static void testgetVerionByPath() {
        System.out.println(getVerionByPath("galaxy-debug.jar"));
    }

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

    public static void StringIntersection() {
        String s1 = "流信息";
        String s2 = "物";
        Set<Character> h1 = new HashSet<Character>();
        Set<Character> h2 = new HashSet<Character>();
        for(int i = 0; i < s1.length(); i++) {
            h1.add(s1.charAt(i));
        }
        for(int i = 0; i < s2.length(); i++) {
            h2.add(s2.charAt(i));
        }
        h1.retainAll(h2);
        for (Character c : h1) {
            System.out.println(c);
        }
    }

    public static void testStringIntersection() {
        StringIntersection();
    }

    public static void testStringCompare() {
        String s1 = "123";
        String s2 = "120";
        System.out.println(s1.compareTo(s2));
    }

    public static void testStringsplit() {
        String s1 = "%你好%微信%";
        String query = "你好请帮我看下是不是微信的问题";
        String[] arr = StringUtils.split(s1, "%");
        System.out.println("len : " + arr.length);
        printArr(arr);
        if (wordsInQuery(arr, query)) {
            System.out.println(s1 + " in " + query);
        } else {
            System.out.println(s1 + " not in " + query);
        }
    }

    public static <T> void printArr(T[] arr) {
        for (T tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static boolean wordsInQuery(final String[] words, final String query) {
        if (words.length == 0) {
            return false;
        }
        final String any = ".*";
        StringBuilder sb = new StringBuilder();
        sb.append(any);
        for (String tmp : words) {
            sb.append(tmp).append(any);
        }
        String pattern = sb.toString();
        return Pattern.matches(pattern, query);
    }

    public static void main(String[] args) {
        //testgetVerionByPath();
        testStringsplit();
    }
}
