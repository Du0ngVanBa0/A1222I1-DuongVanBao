package ss1_introduction_java.bai_tap;

import java.util.Scanner;

public class ExchangeMoney {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount USD to exchange: ");
        int usd = sc.nextInt();
        System.out.println("VND = " + usd * rate);
    }
}
