package thread.producermodel;

/**
 * Created by samo on 2018/4/19.
 *
 * @author samo
 * @date 2018/04/19
 */
public abstract class AbstractConsumer implements Consumer, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
