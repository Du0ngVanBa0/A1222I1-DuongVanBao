package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class ElementDeleteArray {
    static int[] deleteAnElement(int[] a, int pos) {
        int[] newA = new int[a.length-1];
        int iNewA = 0;
        for (int i = 0; i < a.length; i++) {
            if (i!=pos){
                newA[iNewA] = a[i];
                iNewA++;
            }
        }
        return newA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{10, 4, 6, 7, 8, 6};
        System.out.print("Array: ");
        for (int j : arr) {
            System.out.print(j + "  ");
        }
        System.out.print("\nEnter a number need to delete: ");
        int e = Integer.parseInt(sc.nextLine()), indexFind = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                indexFind = i;
                break;
            }
        }
        if (indexFind != -1) {
            arr = deleteAnElement(arr, indexFind);
            System.out.print("Array: ");
            for (int i : arr) {
                System.out.print(i + "  ");
            }
        } else {
            System.out.println("Can't find this number");
        }
    }
}
