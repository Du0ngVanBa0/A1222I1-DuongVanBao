package ss7_abstract_and_interface.bai_tap.colorable_interface;

import com.sun.org.apache.bcel.internal.generic.I2F;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle();
        shapes[1] = new Square(23);
        shapes[2] = new Rectangle();
        shapes[3] = new Square(5);
        shapes[4] = new Square(4.5);

        for (Shape shape : shapes) {
            System.out.println(shape + " has area: " + shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
