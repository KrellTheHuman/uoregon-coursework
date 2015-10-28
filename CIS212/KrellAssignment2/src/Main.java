import java.util.ArrayList;
import java.util.Random;

/**
 * CIS212 - Assignment 2
 * Created by Krell on 2015-10-05.
 *
 * Findings:
 * It takes far less time to create a dense array, or to convert a sparse array to a dense array.
 * The dense array size doesn't change based on density, so if the array holds a lot of zero values, memory is being wasted.
 *
 * Conversely, the sparse array takes far longer to create, or to convert a dense array to a sparse array.
 * The sparse array's size is directly related to the density, so it can potentially save space in memory.
 *
 * So which to use? If I value processing speed over memory footprint, I would likely choose the dense array.
 * If conserving memory outweighs processing speed, I would likely choose the sparse array.
 *
 * Additionally, I found that my first implementation of converting a sparse array to a dense array took several minutes at array length of 100,000,000.
 * My first attempt had a nested for loop, wherein, for each element of the new dense array, I iterated over each element of the sparse array.
 * My final implementation takes mere seconds, which I arrived at after I realized that a Java array of int initializes each element to 0.
 * I then only needed to iterate over the sparse array, and for each element, replace the respective element in the dense array.
 */

public class Main {
    public static void main(String[] args) {

        // constants
        final int MIN = 1;
        final int MAX = 1000000;

        // utilities
        Stopwatch stopwatch = new Stopwatch();
        Random random = new Random();

        // get array parameters from user
        Prompter prompter = new Prompter();
        int arrayLength = prompter.getArrayLength();
        double arrayDensity = prompter.getArrayDensity();

        // create dense array
        System.out.print("creating dense array...");
        stopwatch.start();
        int[] denseArray = createDenseArray(arrayLength, arrayDensity, random, MAX, MIN);
        stopwatch.stop();
        System.out.printf("\rcreated dense array length: %,d created in: %,.3f ms\n", denseArray.length, stopwatch.getTime());

        // convert to sparse array
        System.out.print("converting to sparse array...");
        stopwatch.start();
        ArrayList<int[]> sparseFromDenseArray = convertToSparseArray(denseArray);
        stopwatch.stop();
        System.out.printf("\rconverted to sparse array length: %,d converted in: %,.3f ms\n", sparseFromDenseArray.size(), stopwatch.getTime());

        // create sparse array
        System.out.print("creating sparse array...");
        stopwatch.start();
        ArrayList<int[]> sparseArray = createSparseArray(arrayLength, arrayDensity, random, MAX, MIN);
        stopwatch.stop();
        System.out.printf("\rcreated sparse array length: %,d created in: %,.3f ms\n", sparseArray.size(), stopwatch.getTime());

        // convert to dense array
        System.out.print("converting to dense array...");
        stopwatch.start();
        int[] denseFromSparseArray = convertToDenseArray(sparseArray, arrayLength);
        stopwatch.stop();
        System.out.printf("\rconverted to dense array length: %,d converted in: %,.3f ms\n", denseFromSparseArray.length, stopwatch.getTime());

        // find dense array max value and index
        System.out.print("finding dense max value...");
        stopwatch.start();
        int[] maxDenseIndexAndValue = getMaxDenseIndexAndValue(denseArray);
        stopwatch.stop();
        System.out.printf("\rfind dense max value: %,d @index: %d found in: %,.3f ms\n", maxDenseIndexAndValue[1], maxDenseIndexAndValue[0], stopwatch.getTime());

        // find sparse array max value and index
        System.out.print("finding sparse max value...");
        stopwatch.start();
        int[] maxSparseIndexAndValue = getMaxSparseIndexAndValue(sparseArray);
        stopwatch.stop();
        System.out.printf("\rfind sparse max value: %,d @index: %d found in: %,.3f ms\n", maxSparseIndexAndValue[1], maxSparseIndexAndValue[0], stopwatch.getTime());
    }

    private static int[] createDenseArray(int arrayLength, double arrayDensity, Random random, final int MAX, final int MIN) {
        int[] denseArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            if (arrayDensity >= random.nextDouble()) {
                denseArray[i] = random.nextInt(MAX - MIN + 1) - MIN;
            } else {
                denseArray[i] = 0;
            }
        }
        return denseArray;
    }

    private static ArrayList<int[]> convertToSparseArray(int[] denseArray) {
        ArrayList<int[]> sparseFromDenseArray = new ArrayList<>();
        for (int i = 0; i < denseArray.length; i++) {
            if (denseArray[i] != 0) {
                sparseFromDenseArray.add(new int[]{i, denseArray[i]});
            }
        }
        return sparseFromDenseArray;
    }

    private static ArrayList<int[]> createSparseArray(int arrayLength, double arrayDensity, Random random, final int MAX, final int MIN) {
        ArrayList<int[]> sparseArray = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            if (arrayDensity >= random.nextDouble()) {
                sparseArray.add(new int[]{i, random.nextInt(MAX - MIN + 1) - MIN});
            }
        }
        return sparseArray;
    }

    private static int[] convertToDenseArray(ArrayList<int[]> sparseArray, int arrayLength) {
        int[] denseFromSparseArray = new int[arrayLength];
        for (int[] element : sparseArray) {
            denseFromSparseArray[element[0]] = element[1];
        }
        return denseFromSparseArray;
    }

    private static int[] getMaxDenseIndexAndValue(int[] denseArray) {
        int[] maxDenseIndexAndValue = new int[]{0, 0}; // index, value
        for (int i = 0; i < denseArray.length; i++) {
            if (denseArray[i] > maxDenseIndexAndValue[1]) {
                maxDenseIndexAndValue[0] = i;
                maxDenseIndexAndValue[1] = denseArray[i];
            }
        }
        return maxDenseIndexAndValue;
    }

    private static int[] getMaxSparseIndexAndValue(ArrayList<int[]> sparseArray) {
        int[] maxSparseIndexAndValue = new int[]{0, 0}; // index, value
        for (int[] element : sparseArray) {
            if (element[1] > maxSparseIndexAndValue[1]) {
                maxSparseIndexAndValue[0] = element[0];
                maxSparseIndexAndValue[1] = element[1];
            }
        }
        return maxSparseIndexAndValue;
    }
}
