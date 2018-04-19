package thread.producermodel;

/**
 * Created by samo on 2018/4/19.
 *
 * @author samo
 * @date 2018/04/19
 */
public abstract class AbstractProducer implements Producer, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
