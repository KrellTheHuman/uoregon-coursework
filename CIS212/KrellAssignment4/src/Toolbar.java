import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private PaintPanel _paintPanel;
    private JButton _smallBrush;
    private JButton _mediumBrush;
    private JButton _largeBrush;
    private JButton _brushSmaller;
    private JButton _brushBigger;
    private JButton _clear;
    private JButton _save;
    private static int _brushSize = 35;

    public Toolbar(PaintPanel paintPanel) {

        _paintPanel = paintPanel;
        _smallBrush = new JButton("small");
        _mediumBrush = new JButton("medium");
        _largeBrush = new JButton("large");
        _brushSmaller = new JButton("brush--");
        _brushBigger = new JButton("brush++");
        _clear = new JButton("clear");
        _save = new JButton("save");

        _smallBrush.setFont(new Font("Arial", Font.PLAIN, 32));
        _mediumBrush.setFont(new Font("Arial", Font.PLAIN, 32));
        _largeBrush.setFont(new Font("Arial", Font.PLAIN, 32));
        _brushSmaller.setFont(new Font("Arial", Font.PLAIN, 32));
        _brushBigger.setFont(new Font("Arial", Font.PLAIN, 32));
        _clear.setFont(new Font("Arial", Font.PLAIN, 32));
        _save.setFont(new Font("Arial", Font.PLAIN, 32));

        _smallBrush.addActionListener(this);
        _mediumBrush.addActionListener(this);
        _largeBrush.addActionListener(this);
        _brushSmaller.addActionListener(this);
        _brushBigger.addActionListener(this);
        _clear.addActionListener(this);
        _save.addActionListener(this);

        setLayout(new GridLayout(0, 1));

        add(_smallBrush);
        add(_mediumBrush);
        add(_largeBrush);
        add(_brushSmaller);
        add(_brushBigger);
        add(_clear);
        add(_save);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _smallBrush) {
            _brushSize = Brush.SMALL;
        } else if (e.getSource() == _mediumBrush) {
            _brushSize = Brush.MEDIUM;
        } else if (e.getSource() == _largeBrush) {
            _brushSize = Brush.LARGE;
        } else if (e.getSource() == _brushSmaller) {
            setBrushSmaller();
        } else if (e.getSource() == _brushBigger) {
            setBrushLarger();
        } else if (e.getSource() == _clear) {
            _paintPanel.clearCanvas();
        } else if (e.getSource() == _save) {
            _paintPanel.save();
        }
    }

    private void setBrushSmaller() {
        if (_brushSize > 3) {
            _brushSize -= 3;
        } else {
            _brushSize = 3;
        }
    }

    private void setBrushLarger() {
        if (_brushSize < 97) {
            _brushSize += 3;
        } else {
            _brushSize = 100;
        }
    }

    public static int getBrushSize() {
        return _brushSize;
    }
}
