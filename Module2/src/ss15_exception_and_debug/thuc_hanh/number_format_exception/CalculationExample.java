package ss15_exception_and_debug.thuc_hanh.number_format_exception;

import java.util.Scanner;

public class CalculationExample {
    public static void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = " + a);
            System.out.println("Hiệu x - y = " + b);
            System.out.println("Tích x * y = " + c);
            System.out.println("Thương x / y = " + d);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap x: ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap y: ");
        int y = Integer.parseInt(sc.nextLine());
        calculate(x, y);
    }
}
