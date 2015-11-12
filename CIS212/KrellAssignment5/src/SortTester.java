import java.util.ArrayList;

public class SortTester {

    // called after each sort
    public static boolean testAlphaSort(ArrayList<PhonebookEntry> phonebookEntries) {

        for (int i = 0; i < phonebookEntries.size() - 1; i++) {
            if (phonebookEntries.get(i).getFullName().compareTo(phonebookEntries.get(i + 1).getFullName()) > 0) {
                return false;
            }
        }
        return true;
    }
}
