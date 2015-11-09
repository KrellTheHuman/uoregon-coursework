import java.util.ArrayList;

public class SortTester {

    public static boolean testAlphaSort(ArrayList<PhonebookEntry> phonebookEntries) {

        PhonebookEntry minEntry = phonebookEntries.get(0);
        for (PhonebookEntry phonebookEntry : phonebookEntries) {
            if (phonebookEntry.getLastName().compareTo(minEntry.getLastName()) < 0) {
                return false;
            }
            minEntry = phonebookEntry;
        }
        return true;
    }
}
