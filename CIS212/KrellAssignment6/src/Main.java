
/**
 * CIS212 - Assignment 6
 * Created by krell on 2015-11-15.
 */

public class Main {
    public static void main(String[] args) {

        OccurrenceSet<Integer> intSet = new OccurrenceSet<>();
        intSet.add(1);
        intSet.add(3);
        intSet.add(5);
        intSet.add(5);
        intSet.add(3);
        intSet.add(3);
        intSet.add(3);
        System.out.println(intSet);

        OccurrenceSet<String> stringSet = new OccurrenceSet<>();
        stringSet.add("hello");
        stringSet.add("hello");
        stringSet.add("world");
        stringSet.add("world");
        stringSet.add("world");
        stringSet.add("here");
        System.out.println(stringSet);
    }
}


