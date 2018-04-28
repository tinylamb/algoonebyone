package effective.objecttips;

/**
 * Created by samo on 2018/4/28.
 *
 * @author samo
 * @date 2018/04/28
 */
public class Equals {

    private Object object;

    public boolean stringEquals(Object obj) {
        if (object == obj) {
            return true;
        }
        if (obj instanceof String) {
            String sobj = (String)obj;
            //转成相同的类型后,再对关键值做相等判断
            //TODO
            return true;
        }
        return false;
    }
}
