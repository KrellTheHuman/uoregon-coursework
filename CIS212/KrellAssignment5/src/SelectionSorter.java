import java.util.ArrayList;

public class SelectionSorter {

    public static String selectionSortTime = "0 ms";
    public static int selectionSortComparisons = 0;
    private static Stopwatch _stopwatch = new Stopwatch();

    public static void performSelectionSort() {
        Thread thread = new Thread(() -> {
            selectionSortTime = "sorting...";
            _stopwatch.start();
            ArrayList<PhonebookEntry> selectionSorted = SelectionSorter.selectionSort(Main.phonebook.getPhonebookEntries());
            _stopwatch.stop();
            selectionSortTime = SortTester.testAlphaSort(selectionSorted) ? _stopwatch.toString() : "Error";
            MainPanel.enableSelectionSortButton();
        });
        thread.start();
    }

    public static ArrayList<PhonebookEntry> selectionSort(ArrayList<PhonebookEntry> phonebookEntries) {

        ArrayList<PhonebookEntry> sortPhonebookEntries = new ArrayList<>(phonebookEntries);
        int minEntryIndex = 0;
        selectionSortComparisons = 0;

        while (minEntryIndex < sortPhonebookEntries.size()) {
            for (int i = minEntryIndex; i < sortPhonebookEntries.size(); i++) {
                if (sortPhonebookEntries.get(minEntryIndex).getFullName().compareTo(sortPhonebookEntries.get(i).getFullName()) > 0) {
                    // simple swap
                    PhonebookEntry temp = new PhonebookEntry(sortPhonebookEntries.get(minEntryIndex));
                    sortPhonebookEntries.set(minEntryIndex, sortPhonebookEntries.get(i));
                    sortPhonebookEntries.set(i, temp);
                }
                selectionSortComparisons++;
            }
            minEntryIndex++;
        }

        return sortPhonebookEntries;
    }
}
