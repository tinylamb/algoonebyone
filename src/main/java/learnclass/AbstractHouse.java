package learnclass;

/**
 * Created by samo on 2018/4/22.
 *
 * @author samo
 * @date 2018/04/22
 */
public abstract class AbstractHouse {
    protected void price() {
        System.out.println("how much");
    }


    public <T> T returnVal(T result) {
        return result;
    }

    public <T extends Integer> int add(T x, T y) {
        return x.compareTo(y);
    }

}
