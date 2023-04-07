package ss6_ke_thua.bai_tap.triangle_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = 0, b = 0, c = 0;
        String col;
        do {
            System.out.print("Enter 3 sides of Triangle: ");
            a = Double.parseDouble(sc.nextLine());
            b = Double.parseDouble(sc.nextLine());
            c = Double.parseDouble(sc.nextLine());
            if (a + b <= c || b + c <= a || a + c <= b){
                System.out.println("It's not 3 sides of a triangle. Please enter again: ");
            }
        }
        while (a + b <= c || b + c <= a || a + c <= b);
        System.out.print("Enter color of Triangle: ");
        col = sc.nextLine();
        Shape tg1 = new Triangle(col,a,b,c);
        System.out.println(tg1);
    }
}
