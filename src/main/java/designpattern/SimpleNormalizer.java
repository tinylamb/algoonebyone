package designpattern;

/**
 * Created by samo on 2017/10/20.
 *
 * @author samo
 * @date 2017/10/20
 */
public class SimpleNormalizer {
    private SimpleNormalizer() {
        System.out.println("i am private");
    }

    private static SimpleNormalizer singleton = new SimpleNormalizer();

    public static SimpleNormalizer getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(SimpleNormalizer.class.getSimpleName());
        //SimpleNormalizer sn = SimpleNormalizer.getInstance();
    }
}
