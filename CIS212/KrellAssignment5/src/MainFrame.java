import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

    private MainPanel _mainPanel;

    public MainFrame() {
        super("Krell's Sort Comparison");

        setLayout(new BorderLayout());

        _mainPanel = new MainPanel();
        add(_mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
