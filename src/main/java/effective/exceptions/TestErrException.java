package effective.exceptions;

/**
 * Created by samo on 2018/5/2.
 *
 * @author samo
 * @date 2018/05/02
 */
public class TestErrException {
    public static void throwE() throws ErrException {
        throw new ErrException(ErrCode.MISSING_HEADER);
    }

    public static void main(String[] args ) {
        try {
            throwE();
        } catch (ErrException e) {
            e.printStackTrace();
            System.out.println(e.getErrorMsg());
        }
    }
}
