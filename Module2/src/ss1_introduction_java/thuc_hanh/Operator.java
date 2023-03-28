package ss1_introduction_java.thuc_hanh;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = scanner.nextFloat();

        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        float area = height * width;

        System.out.println("Area is: " + area);
    }
}
