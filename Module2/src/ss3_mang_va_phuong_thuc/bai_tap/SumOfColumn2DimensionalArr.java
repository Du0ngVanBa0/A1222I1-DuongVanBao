package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class SumOfColumn2DimensionalArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input size of 2-Dimensional Array: ");
        int size = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[size][];
        int i1 = 0, j1 = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Input length of row %d: ", i);
            arr[i] = new int[Integer.parseInt(sc.nextLine())];
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
        int column, sum = 0;
        System.out.println("Enter column need to sum: ");
        column = Integer.parseInt(sc.nextLine());
        for (int[] r : arr) {
            if (r.length>column) {
                sum += r[column];
            }
        }
        System.out.printf("Sum of column %d is %d", column, sum);
    }
}
