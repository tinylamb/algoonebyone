package thread;

import java.util.concurrent.CountDownLatch;

import lombok.Data;

/**
 * Created by samo on 2018/4/15.
 *
 * @author samo
 * @date 2018/04/15
 */
@Data
public abstract class BaseHealthChecker implements Runnable {
    private CountDownLatch _latch;
    private String _serviceName;
    private boolean _serviceUp;

    //Get latch object in constructor so that after completing the task, thread can countDown() the latch
    public BaseHealthChecker(String serviceName, CountDownLatch latch) {
        super();
        this._latch = latch;
        this._serviceName = serviceName;
        this._serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verifyService();
            _serviceUp = true;
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            _serviceUp = false;
        } finally {
            if(_latch != null) {
                _latch.countDown();
            }
        }
    }

    public abstract void verifyService();
}
