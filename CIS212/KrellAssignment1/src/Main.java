/**
 * CIS212 - Assignment 1
 * Created by Krell on 2015-09-28.
 */

public class Main {
    public static void main(String[] args) {

        Prompter prompter = new Prompter();
        int result = 1;
        int userInput;

        while (true) {
            userInput = prompter.getUserInput();
            if (userInput < -3) continue;
            switch (userInput) {
                case -1: // quit
                    System.out.println("Goodbye.");
                    System.exit(0);
                case -2: // print current result
                    System.out.println("The number is: " + result);
                    break;
                case -3: // reset
                    System.out.println("Resetting the number to: 1.");
                    result = 1;
                    break;
                default: // multiply
                    int newResult = multiplyByResult(result, userInput);
                    if (newResult != result) {
                        System.out.println("Multiplying " + result + " by " + userInput + ".");
                        result = newResult;
                    }
                    break;
            }
        }
    }

    public static int multiplyByResult(int result, int userInput) {
        long product = result * userInput;
        // check for integer overflow
        if (product > Integer.MAX_VALUE || product < 0) {
            System.out.println("Declined. Multiplying by that number would exceed the maximum integer value of " + Integer.MAX_VALUE + ".");
            return result;
        } else {
            return result *= userInput;
        }
    }
}
