import javax.swing.SwingUtilities;

/**
 * CIS212 - Assignment 5
 * Created by krell on 2015-11-04.
 */

public class Main {

    public static Phonebook phonebook = new Phonebook("phonebook.txt");

    public static void main(String[] args) {

        SwingUtilities.invokeLater(MainFrame::new);
    }
}
