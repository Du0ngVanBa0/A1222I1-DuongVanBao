package ss3_mang_va_phuong_thuc.thuc_hanh;

import java.util.Scanner;

public class TemperatureConvert {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * (9.0 / 5)) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * (5.0 / 9);
    }

    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("0. Exit");
        do {
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            if (choice < 0 || choice > 2) {
                System.out.println("Invalid choice!");
            }
        } while (choice < 0 || choice > 2);
        switch (choice) {
            case 1:
                System.out.print("Enter fahrenheit: ");
                double f = Float.parseFloat(sc.nextLine());
                System.out.println("Result: " + fahrenheitToCelsius(f));
                break;
            case 2:
                System.out.print("Enter celsius: ");
                double c = Float.parseFloat(sc.nextLine());
                System.out.println("Result: " + celsiusToFahrenheit(c));
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
