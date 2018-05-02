package effective.exceptions;

/**
 * Created by samo on 2018/5/2.
 *
 * @author samo
 * @date 2018/05/02
 */
public class TestErrException {
    //throws ErrException
    public static void throwE()  {
        throw new ErrException(ErrCode.MISSING_HEADER);
    }

    public static void main(String[] args) {
        throwE();
        //try {
        //    throwE();
        //} catch (ErrException e) {
        //    e.printStackTrace();
        //    System.out.println(e.getErrorMsg());
        //}
    }
}
