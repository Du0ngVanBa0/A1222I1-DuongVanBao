package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class MenuPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                for (int i = 1; i <= 5; i++) {
                    String str = "";
                    for (int j = 1; j <= 10; j++) {
                        str += "*";
                    }
                    System.out.println(str);
                }
                break;
            case 2:
                System.out.println("botton-left");
                for (int i = 1; i <= 5; i++) {
                    String str = "";
                    for (int j = 1; j <= i; j++) {
                        str += "*";
                    }
                    System.out.println(str);
                }
                System.out.println("botton-right");
                for (int i = 1; i <= 5; i++) {
                    String str = "";
                    for (int j = 5; j >= 1; j--) {
                        if (j <= i)
                            str += "*";
                        else
                            str += " ";
                    }
                    System.out.println(str);
                }
                System.out.println("top-left");
                for (int i = 5; i >= 1; i--) {
                    String str = "";
                    for (int j = 1; j <= i; j++) {
                        str += "*";
                    }
                    System.out.println(str);
                }
                System.out.println("top-right");
                for (int i = 5; i >= 1; i--) {
                    String str = "";
                    for (int j = 5; j >= 1; j--) {
                        if (j <= i)
                            str += "*";
                        else {
                            str += " ";
                        }
                    }
                    System.out.println(str);
                }
                break;
            case 3:
                for (int i = 1; i <= 5; i++) {
                    String str = "";
                    for (int j = 5; j >= 1; j--) {
                        if (j <= i)
                            str += "*";
                        else {
                            str += " ";
                        }
                    }
                    for (int k =1;k<i;k++){
                        str+="*";
                    }
                    System.out.println(str);
                }
                break;
            case 0:
                System.out.println("Exit!");
                break;
            default:
                System.out.println("No choice");
        }
    }
}
