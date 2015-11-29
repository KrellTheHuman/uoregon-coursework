import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {

    private LinkedBlockingQueue<String> _queue = new LinkedBlockingQueue<>();
    private int _putCount = 0;

    public Producer(LinkedBlockingQueue<String> queue) {
        _queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 2000000; i++) {
            try {
                _queue.put(String.valueOf(UUID.randomUUID()));
                putCount();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Main.producing = false;
        System.out.println("done producing! " + _putCount + " produced");
    }

    private void putCount() {
        _putCount++;
        if (_putCount % 1000 == 0) {
            System.out.println("produced: " + _putCount);
        }
    }
}
