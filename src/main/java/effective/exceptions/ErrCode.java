package effective.exceptions;

/**
 * Created by samo on 2018/5/2.
 *
 * @author samo
 * @date 2018/05/02
 */
public enum ErrCode {
    /**
     * INVALID_REQUEST
     * MISSING_PARAMETER
     * MISSING_HEADER
     */
    INVALID_REQUEST(0, "The request is invalid"),
    MISSING_PARAMETER(1, "Required query parameter is missing"),
    MISSING_HEADER(2, "Required header is missing") ;

    private int id;
    private String msg;

    ErrCode(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
}
