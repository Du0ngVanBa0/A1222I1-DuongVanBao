package ss6_ke_thua.bai_tap.circle_and_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                " radius= " + radius +
                " color= " + color +
                " area= "+ getArea() +
                '}';
    }

    public static void main(String[] args) {
        Circle tron = new Circle(10,"red");
        System.out.println(tron);
    }
}
