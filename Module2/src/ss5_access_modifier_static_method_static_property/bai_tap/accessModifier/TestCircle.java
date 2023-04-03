package ss5_access_modifier_static_method_static_property.bai_tap.accessModifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("Radius: " + c1.getRadius());
        Circle c2 = new Circle();
        System.out.println("Area: " + c1.getArea());
    }
}
