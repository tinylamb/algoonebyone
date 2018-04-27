package effective.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by samo on 2018/4/27.
 *
 * @author samo
 * @date 2018/04/27
 */
public class TestSingleton {
    public static void main(String[] args) {
        String filename = "/Users/samo/data.obj";
        //SingletonWithHolder instance = SingletonWithHolder.getInstance();
        SimpleSingleton instance = SimpleSingleton.getInstance();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(instance);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            SimpleSingleton instance1 = (SimpleSingleton) in.readObject();

            in = new ObjectInputStream(new FileInputStream(filename));
            SimpleSingleton instance2 = (SimpleSingleton) in.readObject();

            System.out.println("obj1 hashcode:" + instance1.hashCode());
            System.out.println("obj2 hashcode:" + instance2.hashCode());

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
