package generic;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by samo on 2018/4/13.
 *
 * @author samo
 * @date 2018/04/13
 */
public interface MyListInterface<E> extends Collection<E>{
    @Override
    default int size() {
        return 0;
    }

    @Override
    default boolean isEmpty() {
        return false;
    }

    @Override
    default boolean contains(Object o) {
        return false;
    }

    @Override
    default Iterator<E> iterator() {
        return null;
    }

    @Override
    default Object[] toArray() {
        return new Object[0];
    }

    @Override
    default <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    default boolean add(E e) {
        return false;
    }

    @Override
    default boolean remove(Object o) {
        return false;
    }

    @Override
    default boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    default boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    default boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    default boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    default void clear() {

    }

    @Override
    default boolean equals(Object o) {
        return false;
    }

    @Override
    default int hashCode() {
        return 0;
    }
}
