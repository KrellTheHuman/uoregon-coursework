public class Stopwatch {
    private long _time;

    public Stopwatch() {
        _time = System.nanoTime();
    }

    public void start() {
        // reinitialize
        _time = System.nanoTime();
    }

    public void stop() {
        // save delta time
        _time = System.nanoTime() - _time;
    }

    public double getTime() {
        // convert nanoseconds to fractional milliseconds
        return (double) _time / 1000000;
    }
}
