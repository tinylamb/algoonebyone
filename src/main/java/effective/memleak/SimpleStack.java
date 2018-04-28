package effective.memleak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by samo on 2018/4/27.
 *
 * @author samo
 * @date 2018/04/27
 */
public class SimpleStack {
    private int size = 0;
    private static final int INIT_SIZE = 2;
    private Object[] elems;

    public SimpleStack() {
        elems = new Object[INIT_SIZE];
    }

    public void push(Object o) {
        ensureCapacity();
        elems[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elems[--size];
        elems[size] = null; // Eliminate obsolete reference return result;
        return result;

    }

    private void ensureCapacity() {
        if (elems.length == size) {
            elems = Arrays.copyOf(elems, 2 * size + 1);
        }
    }
}
