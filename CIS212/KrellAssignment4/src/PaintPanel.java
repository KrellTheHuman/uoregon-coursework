import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PaintPanel extends JPanel {

    private static final ArrayList<Brush> strokes = new ArrayList<>();
    private BufferedImage bufferedImage = new BufferedImage(715, 710, BufferedImage.TYPE_3BYTE_BGR);
    private Brush _pointerBrush = new Brush();
    private int _brushRadius;
    private Color _brushColor = Color.BLACK;
    private boolean _rainbowOn = false;
    private boolean _redIncreasing = true;
    private boolean _greenIncreasing = true;
    private boolean _blueIncreasing = true;

    public PaintPanel() {
        setBackground(Color.WHITE);
        initPaintImage();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addStrokes(e);
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                addStrokes(e);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                _pointerBrush = new Brush(e.getX(), e.getY(), Toolbar.getBrushSize(), _brushColor);
                _brushRadius = _pointerBrush.getSize() / 2;
                repaint();
            }
        });
    }

    private void addStrokes(MouseEvent e) {
        strokes.add(new Brush(e.getX(), e.getY(), Toolbar.getBrushSize(), _brushColor));
        _pointerBrush = new Brush(e.getX(), e.getY(), Toolbar.getBrushSize(), _brushColor);
        updatePaintImage();
    }

    public void setBrushColor(Color brushColor) {
        _rainbowOn = false;
        _brushColor = brushColor;
    }

    public Color getBrushColor() {
        return _brushColor;
    }

    public void setRainbowMode(boolean mode) {
        _rainbowOn = mode;
    }

    private Color getRainbow(Color oldColor) {
        int red, green, blue;
        if (_redIncreasing) {
            red = Math.min((oldColor.getRed() + 3), 255);
            if (red == 255) _redIncreasing = false;
        } else {
            red = Math.max((oldColor.getRed() - 3), 128);
            if (red == 128) _redIncreasing = true;
        }
        if (_greenIncreasing) {
            green = Math.min((oldColor.getGreen() + 15), 255);
            if (green == 255) _greenIncreasing = false;
        } else {
            green = Math.max((oldColor.getGreen() - 15), 128);
            if (green == 128) _greenIncreasing = true;
        }
        if (_blueIncreasing) {
            blue = Math.min((oldColor.getBlue() + 5), 255);
            if (blue == 255) _blueIncreasing = false;
        } else {
            blue = Math.max((oldColor.getBlue() - 5), 128);
            if (blue == 128) _blueIncreasing = true;
        }

        return new Color(red, green, blue);
    }

    public void clearCanvas() {
        strokes.clear();
        initPaintImage();
        repaint();
    }

    private void initPaintImage() {
        Graphics g = bufferedImage.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    private void updatePaintImage() {
        Graphics g = bufferedImage.createGraphics();

        if (_rainbowOn) {
            _brushColor = getRainbow(_brushColor);
        }
        g.setColor(_brushColor);

        for (Brush brush : strokes) {
            _brushRadius = brush.getSize() / 2;
            g.setColor(brush.getColor());
            g.fillOval(
                    brush.getX() - _brushRadius,
                    brush.getY() - _brushRadius,
                    brush.getSize(),
                    brush.getSize()
            );
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bufferedImage, 0, 0, null);
        g.drawOval(
                _pointerBrush.getX() - _brushRadius,
                _pointerBrush.getY() - _brushRadius,
                _pointerBrush.getSize(),
                _pointerBrush.getSize()
        );
    }

    public void save() {
        int fileSuffix = 0;
        try {
            while (new File("KrellPaint" + fileSuffix + ".png").exists()) {
                fileSuffix++;
            }
            ImageIO.write(bufferedImage, "PNG", new File("KrellPaint" + fileSuffix + ".png"));
        } catch (IOException ioe) {
            System.out.println("Error saving image:");
            System.out.println(Arrays.toString(new Throwable().getStackTrace()));
        }
    }
}
