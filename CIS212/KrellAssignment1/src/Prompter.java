import java.util.Scanner;

public class Prompter {
    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput = -4;

        System.out.print("Enter a positive integer: (-1 to quit, -2 to print, -3 to reset): ");
        if (scanner.hasNextInt()) {
            userInput = scanner.nextInt();
        } else {
            System.out.println("Invalid. Input was either not an integer, or exceeded the maximum integer value of " + Integer.MAX_VALUE + ".");
        }

        return userInput;
    }
}
