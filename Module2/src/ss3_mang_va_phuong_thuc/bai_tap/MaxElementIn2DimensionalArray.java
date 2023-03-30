package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class MaxElementIn2DimensionalArray {
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
                System.out.printf("Input integer element row %d column %d: ",i,j);
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
        int max = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    i1 = i;
                    j1 = j;
                }
            }
        }
        System.out.printf("Row %d Column %d has the max value in this 2-dimensional array = %d.", i1, j1, max);
    }
}
