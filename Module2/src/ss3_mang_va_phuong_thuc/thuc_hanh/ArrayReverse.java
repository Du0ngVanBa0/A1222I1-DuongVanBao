package ss3_mang_va_phuong_thuc.thuc_hanh;

import java.util.Scanner;

public class ArrayReverse {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter a size: ");
            size = Integer.parseInt(sc.nextLine());
            if (size>20){
                System.out.println("Size does not exceed 20");
            }
        } while (size>20);
        array = new int[size];
        int i=0;
        while (i<array.length){
            System.out.print("Enter element "+(i+1)+": ");
            array[i] = Integer.parseInt(sc.nextLine());
            i++;
        }
        System.out.printf("%-20s", "Elements in array: ");
        for (int k : array) {
            System.out.print(k + "\t");
        }
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("\n%-20s", "Reverse array: ");
        for (int k : array) {
            System.out.print(k + "\t");
        }
    }
}
