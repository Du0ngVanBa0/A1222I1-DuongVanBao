package ss4_lop_va_doi_tuong_trong_java.bai_tap.quadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        System.out.println("Enter a, b, c: ");
        a = Double.parseDouble(sc.nextLine());
        b = Double.parseDouble(sc.nextLine());
        c = Double.parseDouble(sc.nextLine());
        QuadraticEquation qe1 = new QuadraticEquation(a, b, c);
        if (qe1.getDiscriminant() > 0){
            System.out.printf("The equation has two roots %.5f and %.5f",qe1.getRoot1(),qe1.getRoot2());
        } else if (qe1.getDiscriminant() == 0) {
            System.out.printf("The equation has one root %.5f",qe1.getRoot1());
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}
