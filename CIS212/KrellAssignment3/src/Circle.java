public class Circle implements Measurable {

    protected double _radius;

    public Circle() {
        this(0);
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public void setRadius(double radius) {
        _radius = radius;
    }

    public double getArea() {
        return Math.PI * _radius * _radius;
    }
}
