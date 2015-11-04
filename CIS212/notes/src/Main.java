import java.util.Random;

/**
 * playground for following along with the lecture
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(factorial(6));
        System.out.println(fibonacci(6));
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
}
