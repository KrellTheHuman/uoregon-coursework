public class Rectangle implements Measurable {

    protected double _width;
    protected double _height;

    public Rectangle() {
        this(0, 0);
    }

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(double width) {
        _width = width;
    }

    public void setHeight(double height) {
        _height = height;
    }

    public double getArea() {
        return _width * _height;
    }
}
