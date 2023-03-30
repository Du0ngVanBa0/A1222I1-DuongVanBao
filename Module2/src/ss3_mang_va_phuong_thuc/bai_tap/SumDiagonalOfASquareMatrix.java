package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class SumDiagonalOfASquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input size of Square Matrix: ");
        int size = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[size][];
        int i1 = 0, j1 = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[size];
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("Input integer element row %d column %d: ", i, j);
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        System.out.printf("Sum Diagonal of Square Matrix: %d",sum);
    }
}
