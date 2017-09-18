package generic;

import java.util.ArrayList;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samo on 2017/9/7.
 *
 * @author samo
 * @date 2017/09/07
 */
public class GenericStack<E> {
    private ArrayList<E> list;// list = null;

    public GenericStack() {
        list = new ArrayList<>();
    }

    public int getSize() {
        return list.size();
    }

    public E peek() {
        return list.get(getSize() - 1);
    }

    public E pop() {
        E o = peek();
        list.remove(getSize() - 1);
        return o;
    }

    public void push(E o) {
        list.add(o);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(list).toString();
        //return new ToStringBuilder(this)
        //    .append("list", list)
        //    .toString();
    }

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack);
    }
}
