package generic;

/**
 * Created by samo on 2017/6/29.
 *
 * @author samo
 * @date 2017/06/29
 */
public class GenericMethodDemo {

    public static void main(String[] args ) {
        Integer[] integers = {1, 2, 3, 4, 5};
        String[] strings = {"London", "Paris", "New York", "Austin"};
        double[] doubles = {1.1, 1.2, 1.3};

        GenericMethodDemo.<Integer>print(integers);
        GenericMethodDemo.<String>print(strings);
        //GenericMethodDemo.<double>print(doubles);

    }

    public static <E> void print(E[] list) {
        for (int i = 0; i < list.length; i++)  {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static <E extends Comparable<E>> void sort(E[] list) {
        E currentMin;
        int currentMinindex;

        for (int i = 0; i < list.length; i++) {
            currentMin = list[i];
            currentMinindex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinindex = j;
                }
            }
            if (currentMinindex != i) {
                list[currentMinindex] = list[i];
                list[i] = currentMin;
            }
        }
    }

}
