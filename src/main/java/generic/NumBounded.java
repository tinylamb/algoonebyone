package generic;

/**
 * Created by samo on 2018/3/14.
 *
 * @author samo
 * @date 2018/03/14
 */
public class NumBounded<T extends Number & Comparable<T>> implements Comparable<NumBounded<T>> {
    private T num;

    public T getNum() {
        return num;
    }

    public void setNum(T num) {
        this.num = num;
    }

    @Override
    public int compareTo(NumBounded<T> o) {
        return num.compareTo(o.num);
    }
}
