import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

    private String _instanceName;
    private LinkedBlockingQueue<String> _queue = new LinkedBlockingQueue<>();
    private int _pollCount = 0;
    private String _maxString = "";

    public Consumer(LinkedBlockingQueue<String> queue, String instanceName) {
        _queue = queue;
        _instanceName = instanceName;
    }

    @Override
    public void run() {

        while (Main.producing) {
            try {
                String newString = _queue.poll(1000, TimeUnit.MILLISECONDS);
                if (newString != null) {
                    pollCount();
                    _maxString = newString.compareTo(_maxString) > 0 ? newString : _maxString;
                    Thread.sleep(new Random().nextInt(10));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(_instanceName + " done consuming! " + _pollCount + " consumed");
        System.out.println(_instanceName + " max String: " + _maxString);
    }

    private void pollCount() {
        _pollCount++;
        if (_pollCount % 1000 == 0) {
            System.out.println(_instanceName + " consumed: " + _pollCount);
        }
    }
}
