package algsexcise.distance;

import java.io.Serializable;

/**
 * Created by samo on 2018/3/21.
 *
 * @author samo
 * @date 2018/03/21
 */
public interface Distance<T> extends Serializable {
    public double d(T x, T y);
}
