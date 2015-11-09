import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Phonebook {

    private ArrayList<PhonebookEntry> _phonebookEntries = new ArrayList<>();

    public Phonebook(String textFile) {
        readPhonebookFile(textFile);
    }

    private void readPhonebookFile(String textFile) {
        try {
            FileReader fileReader = new FileReader(textFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String entry = bufferedReader.readLine();

            while(entry != null) {
                entry = entry.replace(",", "");
                String[] splitEntry = entry.split(" ");
                PhonebookEntry phonebookEntry = new PhonebookEntry(
                        Integer.parseInt(splitEntry[0]),
                        splitEntry[1],
                        splitEntry[2],
                        splitEntry[1] + " " + splitEntry[2]
                );
                _phonebookEntries.add(phonebookEntry);
                entry = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found. quitting.");
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            System.out.println("could not parse file. quitting.");
            e.printStackTrace();
            System.exit(2);
        }

    }

    public ArrayList<PhonebookEntry> getPhonebookEntries() {
        return _phonebookEntries;
    }
}
