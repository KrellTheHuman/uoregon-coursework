public class Box extends Rectangle {

    private double _depth;

    public Box() {
        this(0, 0, 0);
    }

    public Box(double width, double height, double depth) {
        setWidth(width);
        setHeight(height);
        setDepth(depth);
    }

    public void setDepth(double depth) {
        _depth = depth;
    }

    @Override
    public double getArea() {
        return _width * _height * _depth;
    }
}
