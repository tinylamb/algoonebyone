package effective.exceptions;

/**
 * Created by samo on 2018/5/2.
 *
 * @author samo
 * @date 2018/05/02
 */
public class ErrException extends Exception {
    private int errorCode;
    private String errorMsg;

    public ErrException(ErrCode code) {
        this.errorMsg = code.getMsg();
        this.errorCode = code.getId();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
