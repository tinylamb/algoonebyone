package basic;

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

    public static void main(String[] args) {
        //testgetVerionByPath();
        String input = "我是先也说的清楚,超了退货日期,你是你不能退了,我也不往过寄了,你说的能给处理,又不处理。什么玩意。";
        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.length() + " : " + i + " : "+ input.substring(0, i));
        }
    }
}
