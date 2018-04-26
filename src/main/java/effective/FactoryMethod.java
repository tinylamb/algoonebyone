package effective;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by samo on 2018/4/26.
 *
 * @author samo
 * @date 2018/04/26
 */
public class FactoryMethod {

    public static void showBoolean() {
        //hava name
        Boolean b = Boolean.valueOf("true");
        //The Boolean.valueOf(boolean) method illustrates this technique: it never creates an object.
    }

    public static void subClass() {
        List list = Collections.synchronizedList(new ArrayList());
        //SynchronizedList 是List的继承类，也是 package private
    }

}
