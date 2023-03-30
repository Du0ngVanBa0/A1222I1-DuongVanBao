package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class MinElementArray {
    public static int minValue(int[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i=0;i<arr.length;i++){
            System.out.printf("Enter element row %d of integer array: ",i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }
}