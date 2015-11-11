import javax.swing.SwingUtilities;

/**
 * CIS212 - Assignment 5
 * Created by krell on 2015-11-04.
 */

public class Main {

    // create Phonebook object for use in sorting
    public static Phonebook phonebook = new Phonebook("phonebook.txt");

    public static void main(String[] args) {

        // create GUI
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
