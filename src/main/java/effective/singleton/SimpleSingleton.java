package effective.singleton;

import java.io.Serializable;

/**
 * Created by samo on 2018/4/27.
 *
 * @author samo
 * @date 2018/04/27
 */
public class SimpleSingleton implements Serializable {
    private SimpleSingleton() {
        System.out.println("init " + this.getClass().getName());
    }

    private static SimpleSingleton instance = new SimpleSingleton();

    public static SimpleSingleton getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
