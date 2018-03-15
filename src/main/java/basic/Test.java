package basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

    public static void testListRemove() {
        List<String> ls = new ArrayList<>(8);
        ls.add("1");
        ls.add("2");
        ls.add("3");
        for (Iterator<String> it = ls.iterator(); it.hasNext(); ) {
            if (it.next().equals("3")) {
                it.remove();
            }
        }
        System.out.println(ls + " : size : " + ls.size());
    }

    public static int sequenceWords(List<String> ls, final int sequence, final List<String[]> group) {
        if (ls == null || sequence < 1 || sequence > ls.size()) {
            return -1;
        }
        String[] tmpresult = new String[sequence];
        for (int i = 0; i <= ls.size() - sequence; i++) {
            for (int j = 0; j < sequence; j++) {
                tmpresult[j] = ls.get(i + j);
            }
            group.add(tmpresult.clone());
        }
        return 0;

    }

    public static void testsequenceWords() {
        List<String> ls = Arrays.asList("1", "2", "3", "4", "5");
        final int sequence = 4;
        List<String[]> group = new ArrayList<String[]>();
        sequenceWords(ls, sequence, group);
        for (String[] tmp : group) {
            printArr(tmp);
        }
    }

    public static void testRegx() {
        String pattern = ".+:\\d:\\d:\\d";
        String query = "hi:1:2:3";
        if (Pattern.matches(pattern, query)) {
            System.out.println(query);
        }
    }

    public static void testSubStr() {
        String str = "012345";
        Integer start = 0;
        Integer end = 6;
        System.out.println(str.substring(start, end));
    }

    public static void testTimeParse() {
        String time = "2017-12-29 11:23:03";
        if (time.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}") ) {
            System.out.println("time : " + time);
        } else {
            System.out.println("valid time");
        }
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        try {
            d = sdfDate.parse(time);
            System.out.println(sdfDate.format(d));
        } catch (ParseException e) {
            System.out.println("time format err");
        }
    }

    public static String keepValidchar(String input) {
        if (StringUtils.isEmpty(input)) {
            return "";
        }
        Integer maxqueryLen = 30;
        if (input.length() > maxqueryLen) {
            input = input.substring(0, maxqueryLen);
        }
        char[] c = input.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            //非 | 字符
            if ( c[i] != '|' ) {
                c[len++] = c[i];
            }
        }
        char[] result = new char[len];
        System.arraycopy(c, 0, result, 0, len);
        return new String(result);
    }

    public static void testkeepValidchar() {
        String test = "||怎么申请售后";
        String result = keepValidchar(test);
        System.out.println(result);

    }

    public static void testreplaceAll() {
        String input = "|你好|||我是好人";
        input = input.replaceAll("\\|\\|\\|", ",");
        System.out.println(input);
    }

    public static void testSplittriple() {
        String str = "|投诉单号|||侵权投诉";
        String[] arr = StringUtils.split(str, "|||");
        printArr(arr);
    }

    public static void testSplit() {
        String s = "你好 0";
        String s2 = "不好\t1";
        String[] arr = s2.split("\\s+");
        printArr(arr);
    }

    public static void testSpilt2() {
        int i = 3;
        int j = 5;
        double d =  (double) i/j;
        System.out.println(d);
        String s = "天气真好|||是的|呢";
        String[] arr = StringUtils.split(s, "|||");
        System.out.println(arr.length);
        printArr(arr);

        String[] arr1 = StringUtils.splitByWholeSeparator(s, "|||");
        System.out.println(arr1.length);
        printArr(arr1);
    }

    public static void testSubList() {
        List<String> ls = new ArrayList<>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");

        int max = (ls.size() > 3) ? 3 : ls.size();
        System.out.println(ls.subList(0,max));
    }

    public static void testReplaceall() {
        String s = "showtypevalue";
        String query = "";
        String rep = query.replaceAll("\\s{1,}", ",")
            .replaceAll("\\,{1,}", ",")
            .replaceAll("\\?{1,}", "?")
            .replaceAll("[，。；：“”？【】（）]‘’", ",")
            .replaceAll(".*[么么哒|谢谢].*", "")
            .replaceAll(".*[img|qqcom|http].*", "");
        System.out.println(rep);
    }

    public static void testRepall() {
        String s1 = "2         ";
        String srep = s1.replaceAll("\\s+", "");
        String s = "你好\n哦'的#看;天\\拿";
        String rep = s.replaceAll("\\\\|\r|\n|\'|#|;", "");
        System.out.println(s);
        System.out.println(rep);
        System.out.println(srep);
    }

    public static void testPattern() {
        final String pattern = ".+:[-]?\\d+:[\\d,]+:\\d+:[\\d,]+";
        String str = "双11活动:0:0,12:0:0,2";
        if (str.matches(pattern)) {
            System.out.println(str);
        }
    }

    public static void testRep() {
        //http://blog.csdn.net/u012307002/article/details/51298809
        String str = "";
        String rep = str.replaceAll("[\\w\\pP\\pS]", "")
            .replaceAll("\\s+", " ").trim();
        System.out.println(rep);
    }

    public static void testCal() {
        String date = "2018-02-06 20:56:34";
        int days = -365;
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date t = null;
        try {
            t = dfs.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(t);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        Date time = calendar.getTime();
        System.out.println(dfs.format(time));
    }

    public static String getNumberid(String query) {
        if (StringUtils.isEmpty(query)) {
            return "";
        }
        char[] c = query.toCharArray();
        int len = 0;
        boolean start = false;
        boolean end = false;
        for (int i = 0; i < c.length; i++) {
            if (start && end) {
                break;
            }
            if (c[i] >= 48 && c[i] <= 57) {
                c[len++] = c[i];
                start = true;
            } else {
                if (start) {
                    end = true;
                }
            }
        }
        char[] result = new char[len];
        System.arraycopy(c, 0, result, 0, len);
        if (result.length == 17 || result.length == 18) {
            return new String(result);
        } else {
            return "";
        }
    }

    public static void testgetNumberid() {
        String query = "";
        String id = getNumberid(query);
        System.out.println(id);
    }

    private static boolean anycontains(Collection<String> ls, String w) {
        for (String tmp : ls) {
            if (w.contains(tmp.trim())) {
                return true;
            }
        }
        return false;
    }

    public static void testanycontains() {
        List<String> l = Arrays.asList("a", "b");
        Set<String> s = new HashSet<String>(l);
        //String[] arr = new String[] {"a", "b"};
        if (anycontains(s, "b")) {
            System.out.println("anycontains");
        }

    }

    public static boolean allContains(String key, Collection<String> col) {
        return true;
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

    public static void testcombinations() {
        String[] arr = {"A","B","C","D","E","F"};
        final List<String[]> group = new ArrayList<String[]>();
        final int k = 2;
        for (int i = 0; i < arr.length; i++) {
            String[] tmp = new String[i + 1];
            combinations(arr, i + 1,0, tmp, group);
        }
        for (String[] var : group) {
            printArr(var);
        }
    }

    public static void main(String[] args) {
        //testgetVerionByPath();
        testcombinations();
    }
}
