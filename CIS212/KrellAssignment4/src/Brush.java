import java.awt.Color;

public class Brush {

    public static final int SMALL = 10;
    public static final int MEDIUM = 35;
    public static final int LARGE = 75;

    private final int _size;
    private final int _x;
    private final int _y;
    private final Color _color;

    public Brush() {
        this(0, 0, 0, Color.BLACK);
    }

    public Brush(int x, int y, int brushSize, Color color) {
        _size = brushSize;
        _x = x;
        _y = y;
        _color = color;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public int getSize() {
        return _size;
    }

    public Color getColor() {
        return _color;
    }
}
