package effective.objecttips.clone;

/**
 * Created by samo on 2018/4/26.
 *
 * @author samo
 * @date 2018/04/26
 */

import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * Utility for making deep copies (vs. clone()'s shallow copies) of
 * objects. Objects are first serialized and then deserialized. Error
 * checking is fairly minimal in this implementation. If an object is
 * encountered that cannot be serialized (or that references an object
 * that cannot be serialized) an error is printed to System.err and
 * null is returned. Depending on your specific application, it might
 * make more sense to have copy(...) re-throw the exception.
 *
 * A later version of this class includes some minor optimizations.
 */
public class UnoptimizedDeepCopy {

    /**
     * Returns a copy of the object, or null if the object cannot
     * be serialized.
     */
    public static Object copy(Object orig) {
        Object obj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(orig);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return obj;
    }
    /*
    It will only work when the object being copied,
     as well as all of the other objects references directly or indirectly by the object,
     are serializable. (In other words, they must implement java.io.Serializable.)
     Fortunately it is often sufficient to simply declare that a given class implements java.io.Serializable and let Java’s default serialization mechanisms do their thing.
Java Object Serialization is slow, and using it to make a deep copy requires both serializing and deserializing. There are ways to speed it up (e.g., by pre-computing serial version ids and defining custom readObject() and writeObject() methods), but this will usually be the primary bottleneck.
The byte array stream implementations included in the java.io package are designed to be general enough to perform reasonable well for data of different sizes and to be safe to use in a multi-threaded environment. These characteristics, however, slow down ByteArrayOutputStream and (to a lesser extent) ByteArrayInputStream.

     */

}
