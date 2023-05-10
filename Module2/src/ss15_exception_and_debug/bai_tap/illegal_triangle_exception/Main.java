package ss15_exception_and_debug.bai_tap.illegal_triangle_exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Nhap a: ");
                int a = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap b: ");
                int b = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap c: ");
                int c = Integer.parseInt(sc.nextLine());
                if (a <= 0 || b <= 0 || c <= 0 || a + b < c || b + c < a || a + c < b) {
                    throw new IllegalTriangleException("Day khong phai tam giac!");
                } else {
                    System.out.println("Tam giac hop le!");
                    System.exit(0);
                }
            } catch (IllegalTriangleException e) {
                System.out.print(e.getMessage());
            }
        } while (true);
    }
}
