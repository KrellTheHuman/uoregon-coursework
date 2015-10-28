import java.util.ArrayList;
import java.util.Random;

/**
 * CIS212 - Assignment 3
 * Created by Krell on 2015-10-12.
 */

public class Main {
    public static void main(String[] args) {

        final int NUM_MEASURABLES = 1000;
        Random random = new Random();
        ArrayList<Measurable> measurables = new ArrayList<>();
        int RectangleCount = 0;
        int BoxCount = 0;
        int CircleCount = 0;
        int SphereCount = 0;

        for (int i = 0; i < NUM_MEASURABLES; i++) {
            int measurableType = random.nextInt(4) + 1;

            switch (measurableType) {
                case 1: // rectangle
                    measurables.add(new Rectangle(nextDouble(random), nextDouble(random)));
                    RectangleCount++;
                    break;
                case 2: // box
                    measurables.add(new Box(nextDouble(random), nextDouble(random), nextDouble(random)));
                    BoxCount++;
                    break;
                case 3: // circle
                    measurables.add(new Circle(nextDouble(random)));
                    CircleCount++;
                    break;
                case 4: // sphere
                    measurables.add(new Sphere(nextDouble(random)));
                    SphereCount++;
                    break;
                default:
            }
        }

        System.out.printf("rectangles: %,d%n", RectangleCount);
        System.out.printf("boxes: %,d%n", BoxCount);
        System.out.printf("circles: %,d%n", CircleCount);
        System.out.printf("spheres: %,d%n", SphereCount);
        System.out.printf("total area: %,.3f%n", calculateSum(measurables));
    }

    private static double nextDouble(Random random) {
        double randomDouble = random.nextDouble();
        return randomDouble > 0.0 ? randomDouble : Double.MIN_VALUE;
    }

    private static double calculateSum(ArrayList<Measurable> measurables) {
        double sum = 0.0;
        for (Measurable measurable : measurables) {
            sum += measurable.getArea();
        }
        return sum;
    }
}
