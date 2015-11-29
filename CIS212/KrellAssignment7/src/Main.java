import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * CIS212 - Assignment7
 * Created by krell on 2015-11-24.
 */

public class Main {

    public static boolean producing = true;

    public static void main(String[] args) {

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(100000);

        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue, "consumer 1");
        Consumer consumer2 = new Consumer(queue, "consumer 2");

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(producer);
        executor.execute(consumer1);
        executor.execute(consumer2);
        executor.shutdown();
    }
}
