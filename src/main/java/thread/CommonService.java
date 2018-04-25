package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by samo on 2018/4/25.
 *
 * @author samo
 * @date 2018/04/25
 */
public class CommonService {

    public static Client client = new Client();
    public static volatile AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void clientReq() {
        client.req();
        atomicInteger.incrementAndGet();
    }

    private static class Client {
        public Client() {
            System.out.println("init Clinet");
        }

        public void req() {
            System.out.println("client req RPC");
        }

    }
}

