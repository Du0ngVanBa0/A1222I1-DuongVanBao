package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] fArray = new int[3];
        int[] sArray = new int[5];
        for (int i = 0; i < fArray.length; i++) {
            System.out.printf("Input index %d of first array: ", i);
            fArray[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < sArray.length; i++) {
            System.out.printf("Input index %d of second array: ", i);
            sArray[i] = Integer.parseInt(sc.nextLine());
        }
        int[] mergeArray = new int[fArray.length + sArray.length];
//        for (int i = 0; i < fArray.length; i++) {
//            mergeArray[i] = fArray[i];
//        }
        System.arraycopy(fArray, 0, mergeArray, 0, fArray.length);
//        for (int i = 0, j = fArray.length; i < sArray.length; i++,j++) {
//            mergeArray[j] = sArray[i];
//        }
        System.arraycopy(sArray,0,mergeArray,fArray.length,sArray.length);
        System.out.println("Merge Array:");
        for (int i:mergeArray){
            System.out.print(i+"  ");
        }
    }
}
