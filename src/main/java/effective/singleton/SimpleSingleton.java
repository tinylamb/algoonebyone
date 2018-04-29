package effective.singleton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> store = new ArrayList<>();

    private static SimpleSingleton instance = new SimpleSingleton();

    public static SimpleSingleton getInstance() {
        return instance;
    }

    public static SimpleSingleton newInstance() {
        return new SimpleSingleton();
    }

    public void process(List<String> ls) {
        System.out.println("ls hash " + ls.hashCode());
        for (String tmp : ls) {
            System.out.println(tmp);
            store.add(tmp);
        }
    }

    public void readStore() {
        System.out.print("readStore : ");
        for (String tmp : store) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    private Object readResolve() {
        return instance;
    }

    public List<String> getStore() {
        return store;
    }

    public void setStore(List<String> store) {
        this.store = store;
    }
}
