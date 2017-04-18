package functional;

import java.io.Serializable;

/**
 * Created by samo on 2017/4/15.
 *
 * @author samo
 * @date 2017/04/15
 */
@FunctionalInterface
public interface ExtractInfo<E, K> extends Serializable{
    K extract(E e);
}
