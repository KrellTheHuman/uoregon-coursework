import java.util.Scanner;

public class Prompter {
    private Scanner _scanner = new Scanner(System.in);
    private int _arrayLength;
    private double _arrayDensity;

    public Prompter() {
        getArrayLengthInput();
        getArrayDensityInput();
    }

    private void getArrayLengthInput() {
        boolean isValidInput = false;
        do {
            System.out.println("Enter array length (positive integer): ");
            if (_scanner.hasNextInt()) {
                _arrayLength = _scanner.nextInt();
                if (_arrayLength > 0) {
                    isValidInput = true;
                    continue;
                }
            }
            _scanner.next();
            System.out.println("Invalid. Input was either not a positive integer, or exceeded the maximum integer value of " + Integer.MAX_VALUE + ".");
        } while (!isValidInput);
    }

    private void getArrayDensityInput() {
        boolean isValidInput = false;
        do {
            System.out.println("Enter array density [0.0, 1.0): ");
            if (_scanner.hasNextDouble()) {
                _arrayDensity = _scanner.nextDouble();
                if (_arrayDensity >= 0.0 && _arrayDensity < 1.0) {
                    isValidInput = true;
                    continue;
                }
            }
            _scanner.next();
            System.out.println("Invalid. Input was either not a double or was out of range. Must be from 0.0 up to, but not including, 1.0.");
        } while (!isValidInput);
    }

    public int getArrayLength() {
        return _arrayLength;
    }

    public double getArrayDensity() {
        return _arrayDensity;
    }
}
