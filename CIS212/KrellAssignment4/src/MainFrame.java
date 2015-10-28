import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

    private PaintPanel _paintPanel;
    private Toolbar _toolbar;
    private Palette _palette;

    public MainFrame() {
        super("KrellPaint");

        setLayout(new BorderLayout());

        _paintPanel = new PaintPanel();
        _toolbar = new Toolbar(_paintPanel);
        _palette = new Palette(_paintPanel);

        add(_toolbar, BorderLayout.WEST);
        add(_paintPanel, BorderLayout.CENTER);
        add(_palette, BorderLayout.EAST);

        setSize(1024, 768);
        setLocationRelativeTo(null); // center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
