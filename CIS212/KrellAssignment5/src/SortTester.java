import java.util.ArrayList;

public class SortTester {

    // called after each sort
    public static boolean testAlphaSort(ArrayList<PhonebookEntry> phonebookEntries) {

        PhonebookEntry minEntry = phonebookEntries.get(0);
        for (PhonebookEntry phonebookEntry : phonebookEntries) {
            if (phonebookEntry.getFullName().compareTo(minEntry.getFullName()) < 0) {
                return false;
            }
            minEntry = phonebookEntry;
        }
        return true;
    }
}
