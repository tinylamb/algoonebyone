package generic;

/**
 * Created by samo on 2017/9/7.
 *
 * @author samo
 * @date 2017/09/07
 */
public class GenericSort {

    public static void test() {
        Integer[] integers = {2, 5, 1};
        Double[] doubles = {1.9, 0.2, 2.2};
        String[] strings = {"b", "z", "x"};
        sort(integers);
        sort(doubles);
        sort(strings);
        assert issorted(integers);
        printArr(integers);
        printArr(doubles);
        printArr(strings);
    }

    public static <E extends Comparable<E>> void sort(final E[] list) {
        ;
    }

    private static <E extends Comparable<E>> boolean less(E v, E w) {
        return v.compareTo(w) < 0;
    }

    private static <E extends Comparable<E>> boolean issorted(final E[] list) {
        for (int i = 1; i < list.length; i++) {
            if (less(list[i], list[i-1])) {
                return false;
            }
        }
        return true;
    }

    private static <E extends Comparable<E>> void swap(final E[] list, int i, int j) {
        E tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    public static <E> void printArr(E[] arr) {
        for (E tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }

}
