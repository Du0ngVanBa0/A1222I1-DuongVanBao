package ss6_ke_thua.bai_tap.circle_and_cylinder;

public class Cylinder extends Circle {
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume() {
        return height*super.getArea();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                " height= " + height +
                " Volume= " + getVolume() +
                "} is a subclass of " + super.toString();
    }

    public static void main(String[] args) {
        Cylinder c1 = new Cylinder(7.1 , "red",5);
        System.out.println(c1);
    }
}
