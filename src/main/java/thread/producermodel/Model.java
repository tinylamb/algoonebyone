package thread.producermodel;

/**
 * Created by samo on 2018/4/19.
 *
 * @author samo
 * @date 2018/04/19
 */
public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
