package thread.producermodel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by samo on 2018/4/30.
 *
 * @author samo
 * @date 2018/04/30
 */
public class WaitNotifyModel implements Model {

    private final Object BUFFER_LOCK = new Object();
    private final Queue<Task> buffer = new LinkedList<>();
    private final int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public WaitNotifyModel(int cap) {
        this.cap = cap;
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer {
        @Override
        public void consume() throws InterruptedException {
            synchronized (buffer) {
                while (buffer.size() == 0) {
                    buffer.wait();
                }
                Task task = buffer.poll();
                assert task != null;
                // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                try {
                    Thread.sleep(500 + ThreadLocalRandom.current().nextLong(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("consume: " + task.no);
                buffer.notifyAll();
            }
        }
    }

    private class ProducerImpl extends AbstractProducer {
        @Override
        public void produce() throws InterruptedException {
            //while (increTaskNo.get() < 1) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //这个类要用外部类的BUFFER_LOCK,所以不能是静态类
                synchronized (buffer) {
                    while (buffer.size() == cap) {
                        buffer.wait();
                    }
                    Task task = new Task(increTaskNo.getAndIncrement());
                    buffer.offer(task);
                    System.out.println("produce: " + task.no);
                    buffer.notifyAll();
                }
            //}

        }
    }
    public static void main(String[] args) {
        Model model = new WaitNotifyModel(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
