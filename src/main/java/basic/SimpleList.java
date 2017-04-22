package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samo on 2017/4/22.
 *
 * @author samo
 * @date 2017/04/22
 */
public class SimpleList<E> {
    private List<E> elemlists;

    public SimpleList(List<E> elemlists) {
        this.elemlists = elemlists;
    }

    public SimpleList() {
        this.elemlists = new ArrayList<E>();
    }

    public E add(E e) {
        if(elemlists.add(e)) {
            return e;
        } else {
            return null;
        }
    }

    public int size() {
        return elemlists.size();
    }

    public void clear() {
        elemlists.clear();
    }
}
