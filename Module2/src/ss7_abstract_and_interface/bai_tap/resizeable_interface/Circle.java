package ss7_abstract_and_interface.bai_tap.resizeable_interface;

public class Circle extends Shape {
    private double radius = 1.0;

    @Override
    public void resize(double percent) {
        radius *= percent;
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    double getArea() {
        return radius * radius * Math.PI;
    }
}