import java.util.Random;

/**
 * playground for following along with the lecture
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(doMath(9));
        printHeadsOrTails();
    }

    public static int doMath(int n) {
        if (n <= 3) {
            return 3;
        }
        return n * doMath(n - 1);
    }

    public static void printHeadsOrTails() {
        System.out.println(new Random().nextInt(2) == 0 ? "heads" : "tails");
    }
}
