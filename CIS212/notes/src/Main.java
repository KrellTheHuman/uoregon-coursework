import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * playground for following along with the lecture
 */
public class Main {

    public static void main(String[] args) {

        //System.out.println(factorial(6));
        //System.out.println(fibonacci(6));
        //System.out.println(isPrime(45));
        //System.out.println(isPrime(7));

//        int[] arrayOfInts = {3, 2, 7, 1, 13};
//        int[] arrayOfInts2 = {3};
//        int[] arrayOfInts3 = {};
//        System.out.println(smallestInteger(arrayOfInts));
//        System.out.println(smallestInteger(arrayOfInts2));
//        System.out.println(arrayOfInts3.length);
        //System.out.println(smallestInteger(arrayOfInts3));



    }

        public synchronized void print(int start, int end) {
            for (int i = start; i < end; ++i) {
                System.out.println(i);
            }
        }
        public void printNumbersThreaded() {
            ExecutorService executor = Executors.newCachedThreadPool();
            executor.execute(new Runnable() { public void run() { print(0, 10); }});
            executor.execute(new Runnable() { public void run() { print(10, 20); }});
        }

    public static int factorial(int n) {
        return n != 1 ? n * factorial(n - 1) : 1;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int smallestInteger(int[] intArray) {
        int smallest = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < smallest) {
                smallest = intArray[i];
            }
        }
        return smallest;
    }
}
