package polymorphism;

/**
 * Created by samo on 2017/8/19.
 *
 * @author samo
 * @date 2017/08/19
 */
public class Asingle {
    private static Asingle ourInstance = new Asingle();

    public static Asingle getInstance() {
        return ourInstance;
    }

    private Asingle() {
    }
}
