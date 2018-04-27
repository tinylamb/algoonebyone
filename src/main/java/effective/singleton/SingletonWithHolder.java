package effective.singleton;

import java.io.Serializable;

/**
 * Created by samo on 2018/4/27.
 *
 * @author samo
 * @date 2018/04/27
 */
public class SingletonWithHolder implements Serializable {
    private SingletonWithHolder() {
        System.out.println("init " + this.getClass().getName());
    }

    public static SingletonWithHolder getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static SingletonWithHolder instance = new SingletonWithHolder();
    }

}
