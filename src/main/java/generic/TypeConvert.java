package generic;

/**
 * Created by samo on 2017/9/5.
 *
 * @author samo
 * @date 2017/09/05
 */
public class TypeConvert {
    public static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch(ClassCastException e) {
            return null;
        }
    }
    public static void main(String args[]) {
        String s = convertInstanceOfObject("string", String.class);
        System.out.println(s);
        Integer i = convertInstanceOfObject(4, Integer.class);
        System.out.println(i);
        String k = convertInstanceOfObject(345435.34, String.class);
        System.out.println(k);
    }
}
