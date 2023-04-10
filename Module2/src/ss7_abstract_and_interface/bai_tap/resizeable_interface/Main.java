package ss7_abstract_and_interface.bai_tap.resizeable_interface;

public class Main {
    public static void main(String[] args) {
        Shape[] arr = new Shape[3];
        arr[0] = new Circle();
        arr[1] = new Rectangle();
        arr[2] = new Square();

        for (Shape shape : arr) {
            System.out.println(shape + " has area: " + shape.getArea());
        }

        for (Shape shape : arr) {
            shape.resize(Math.random() * 100);
        }

        System.out.println("After resize: ");
        for (Shape shape : arr) {
            System.out.println(shape + " has area: " + shape.getArea());
        }

    }
}
