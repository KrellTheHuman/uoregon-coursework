/**
 * Created by krell on 2016-01-27.
 */
public class CIS407 {
    public static void main(String[] args) {
        printRange(2,8);
        printRange(8,2);
    }

    public static void printRange(int start, int end) {
        int current = start;
        while (current < end) {
            System.out.println(current++);
        }
    }
}
