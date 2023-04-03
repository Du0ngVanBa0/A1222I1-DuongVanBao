package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class First20Prime {
    public static void main(String[] args) {
        int numbers = 20, n = 2, count = 0;
        while (count < numbers) {
            if (isPrime(n)) {
                System.out.print(n + "    ");
                count++;
            }
            n++;
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
