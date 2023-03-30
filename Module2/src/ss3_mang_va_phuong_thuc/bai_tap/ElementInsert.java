package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class ElementInsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{10, 4, 6, 7, 8, 6};
        System.out.print("Array: ");
        for (int j : arr) {
            System.out.print(j + "  ");
        }
        System.out.print("\nEnter a number: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter index to insert %d: ", num);
        int index = Integer.parseInt(sc.nextLine());
        if (index >= 0 && index < arr.length) {
            arr = insertElement(arr, num, index);
            System.out.println("Array after insert: ");
            for (int j : arr) {
                System.out.print(j + "  ");
            }
        } else {
            System.out.println("Can't insert Element");
        }
    }

    static int[] insertElement(int[] a, int num, int pos) {
        int[] newA = new int[a.length + 1];
        int indexNewA = 0;
        for (int i = 0; i < a.length; i++,indexNewA++) {
            if (i == pos){
                newA[indexNewA] = num;
                indexNewA++;
            }
            newA[indexNewA] = a[i];
        }
        return newA;
    }
}
