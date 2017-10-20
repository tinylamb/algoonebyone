package nlp;

/**
 * Created by samo on 2017/7/4.
 *
 * @author samo
 * @date 2017/07/04
 */
public class Normalize {
    public static String toDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375) {
                c[i] = (char)(c[i] - 65248);
            }
        }
        return new String(c);
    }

    private static String keepChi(String input) {
        char[] c = input.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            //if (Character.toString(c[i]).matches("[\u4E00-\u9FA5]+")) {
            //    c[len++] = c[i];
            //}
            if (c[i] >= 19968 && c[i] <= 40869) {
                c[len++] = c[i];
            }
        }
        char[] result = new char[len];
        //for (int j = 0; j < len; j++) {
        //    result[j] = c[j];
        //}
        System.arraycopy(c, 0, result, 0, len);
        return new String(result);

    }
}
