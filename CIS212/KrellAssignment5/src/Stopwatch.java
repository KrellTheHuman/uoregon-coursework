/**
 * adapted from my Assignment 2
 */

public class Stopwatch {

    private long _time;

    public Stopwatch() {
        start();
    }

    public void start() {
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

    @Override
    public String toString() {
        return String.format("%,.3f ms", getTime());
    }
}
