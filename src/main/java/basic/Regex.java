package basic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by samo on 2017/7/13.
 *
 * @author samo
 * @date 2017/07/13
 */
public class Regex {

    private static Pattern fromto = Pattern.compile("(离开).+(发往)");

    public static void main(String[] args) {
        String s1 = "快件到达 常州代派站 ,正在分捡中 ,上一站是 常州分拨中心";
        String s2 = "快件离开 常州代派站 ,已发往 常州分拨中心";
        String s3 = "快件离开 常州分拨中心 ,已发往 常州代派站";
        Matcher m = fromto.matcher(s2);
        if (m.find()) {
            System.out.println("match");
        } else {
            System.out.println("no match");
        }
        Set<String> set = new HashSet<String>();
        String s4 = process(s2);
        System.out.println(s4);
        set.add(s4);

        String s5 = process(s3);
        System.out.println(s5);
        if (set.contains(s5)) {
            System.out.println("contains");
        }

    }

    public static String process(String str) {
        String[] location = str.split(",");
        if (location.length != 2) {
            return "";
        }
        TreeSet<String> set = new TreeSet<String>();
        for (String s : location) {
            String[] info = s.split(" ");
            if (info.length != 2) {
                continue;
            }
            set.add(info[1].trim());
        }
        if (set.size() != 2) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s)
                .append(",");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
