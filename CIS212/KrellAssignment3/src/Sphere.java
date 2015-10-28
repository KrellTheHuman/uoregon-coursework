public class Sphere extends Circle {

    public Sphere() {
        this(0);
    }

    public Sphere(double radius) {
        setRadius(radius);
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * _radius * _radius;
    }
}
