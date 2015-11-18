
/**
 * CIS212 - Assignment 6
 * Created by krell on 2015-11-15.
 */

public class Main {
    public static void main(String[] args) {

        testStringSet();
        testIntSet();
    }

    private static void testStringSet() {
        System.out.println("\n\n************ stringSet ************");
        OccurrenceSet<String> stringSet = new OccurrenceSet<>();
        System.out.println("Adding hello to stringSet. Unique entry?: " + stringSet.add("hello"));
        System.out.println("Adding hello to stringSet. Unique entry?: " + stringSet.add("hello"));
        System.out.println("Adding world to stringSet. Unique entry?: " + stringSet.add("world"));
        System.out.println("Adding world to stringSet. Unique entry?: " + stringSet.add("world"));
        System.out.println("Adding world to stringSet. Unique entry?: " + stringSet.add("world"));
        System.out.println("Adding here to stringSet. Unique entry?: " + stringSet.add("here"));
        System.out.println("\tstringSet with entry counts: " + stringSet.getMap().entrySet().toString());
        System.out.println("\tstringSet toArray: " + stringSet);
        System.out.println("\tstringSet size: " + stringSet.size());
        System.out.println();
    }

    private static void testIntSet() {
        System.out.println("\n\n************ intSet ************");
        OccurrenceSet<Integer> intSet = new OccurrenceSet<>();
        System.out.println("Adding 1 to intSet. Unique Entry?: " + intSet.add(1));
        System.out.println("Adding 3 to intSet. Unique Entry?: " + intSet.add(3));
        System.out.println("Adding 5 to intSet. Unique Entry?: " + intSet.add(5));
        System.out.println("Adding 5 to intSet. Unique Entry?: " + intSet.add(5));
        System.out.println("Adding 3 to intSet. Unique Entry?: " + intSet.add(3));
        System.out.println("Adding 3 to intSet. Unique Entry?: " + intSet.add(3));
        System.out.println("Adding 3 to intSet. Unique Entry?: " + intSet.add(3));
        System.out.println("\tintSet with entry counts: " + intSet.getMap().entrySet().toString());
        System.out.println("\tintSet toArray: " + intSet);
        System.out.println("\tintSet size: " + intSet.size());
        System.out.println();

        System.out.println("Removing 5 from intSet. intSet changed?: " + intSet.remove(5));
        System.out.println("\tintSet with entry counts: " + intSet.getMap().entrySet().toString());
        System.out.println("\tintSet toArray: " + intSet);
        System.out.println("\tintSet size: " + intSet.size());
        System.out.println();

        OccurrenceSet<Integer> intSet2 = new OccurrenceSet<>();
        System.out.println("duplicating to intSet2. intSet2 changed?: " + intSet2.addAll(intSet));
        System.out.println("\tintSet2 with entry counts: " + intSet2.getMap().entrySet().toString());
        System.out.println("\tintSet2 toArray: " + intSet2);
        System.out.println("\tintSet2 size: " + intSet2.size());
        System.out.println();

        System.out.println("Adding 7 to intSet2. Unique Entry?: " + intSet2.add(7));
        System.out.println("Adding 7 to intSet2. Unique Entry?: " + intSet2.add(7));
        System.out.println("\tintSet2 with entry counts: " + intSet2.getMap().entrySet().toString());
        System.out.println("\tintSet2 toArray: " + intSet2);
        System.out.println("\tintSet2 size: " + intSet2.size());
        System.out.println();

        System.out.println("Adding 5 to intSet. Unique Entry?: " + intSet.add(5));
        System.out.println("Adding 5 to intSet. Unique Entry?: " + intSet.add(5));
        System.out.println("Adding 5 to intSet. Unique Entry?: " + intSet.add(5));
        System.out.println("Adding 5 to intSet. Unique Entry?: " + intSet.add(5));
        System.out.println("Adding 5 to intSet. Unique Entry?: " + intSet.add(5));
        System.out.println("Adding 5 to intSet. Unique Entry?: " + intSet.add(5));
        System.out.println("\tintSet with entry counts: " + intSet.getMap().entrySet().toString());
        System.out.println("\tintSet toArray: " + intSet);
        System.out.println("\tintSet size: " + intSet.size());
        System.out.println();

        System.out.println("Adding intSet2 to intSet. intSet changed?: " + intSet.addAll(intSet2));
        System.out.println("\tintSet with entry counts: " + intSet.getMap().entrySet().toString());
        System.out.println("\tintSet toArray: " + intSet);
        System.out.println("\tintSet size: " + intSet.size());
        System.out.println();
    }
}
