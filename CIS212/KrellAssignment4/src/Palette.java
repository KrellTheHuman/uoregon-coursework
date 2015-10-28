import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Palette extends JPanel implements ActionListener {

    private PaintPanel _paintPanel;
    private JButton _black;
    private JButton _white;
    private JButton _red;
    private JButton _green;
    private JButton _blue;
    private JButton _custom;
    private JButton _rainbow;

    public Palette(PaintPanel paintPanel) {

        _paintPanel = paintPanel;
        _black = new JButton("black");
        _white = new JButton("white");
        _red = new JButton("red");
        _green = new JButton("green");
        _blue = new JButton("blue");
        _custom = new JButton("custom");
        _rainbow = new JButton("rainbow");

        _black.setFont(new Font("Arial", Font.PLAIN, 32));
        _white.setFont(new Font("Arial", Font.PLAIN, 32));
        _red.setFont(new Font("Arial", Font.PLAIN, 32));
        _green.setFont(new Font("Arial", Font.PLAIN, 32));
        _blue.setFont(new Font("Arial", Font.PLAIN, 32));
        _custom.setFont(new Font("Arial", Font.PLAIN, 32));
        _rainbow.setFont(new Font("Arial", Font.PLAIN, 32));

        _black.addActionListener(this);
        _white.addActionListener(this);
        _red.addActionListener(this);
        _green.addActionListener(this);
        _blue.addActionListener(this);
        _custom.addActionListener(this);
        _rainbow.addActionListener(this);

        setLayout(new GridLayout(0, 1));

        add(_black);
        add(_white);
        add(_red);
        add(_green);
        add(_blue);
        add(_custom);
        add(_rainbow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _black) {
            _paintPanel.setBrushColor(Color.BLACK);
        } else if (e.getSource() == _white) {
            _paintPanel.setBrushColor(Color.WHITE);
        } else if (e.getSource() == _red) {
            _paintPanel.setBrushColor(Color.RED);
        } else if (e.getSource() == _green) {
            _paintPanel.setBrushColor(Color.GREEN);
        } else if (e.getSource() == _blue) {
            _paintPanel.setBrushColor(Color.BLUE);
        } else if (e.getSource() == _custom) {
            _paintPanel.setBrushColor(JColorChooser.showDialog(_paintPanel, "choose color", _paintPanel.getBrushColor()));
        } else if (e.getSource() == _rainbow) {
            _paintPanel.setRainbowMode(true);
        }
    }
}
