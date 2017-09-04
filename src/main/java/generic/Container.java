package generic;

/**
 * Created by samo on 2017/9/4.
 *
 * @author samo
 * @date 2017/09/04
 */
public class Container<K, V> {
    private K key;
    private V val;

    public Container(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public static <T> void printArr(T[] arr) {
        for (T tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Container<String, String> c1 = new Container<String, String>("name", "findingsea");
        Container<String, Integer> c2 = new Container<String, Integer>("age", 24);
        Container<Double, Double> c3 = new Container<Double, Double>(1.1, 2.2);
        System.out.println(c1.getKey() + " : " + c1.getVal());
        System.out.println(c2.getKey() + " : " + c2.getVal());
        System.out.println(c3.getKey() + " : " + c3.getVal());
    }
}
