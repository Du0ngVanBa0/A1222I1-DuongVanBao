package ss14_thuat_toan_sap_xep.bai_tap.insertion_sort;

import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int pos = i, x = list[pos];
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            if (list[pos] != x) {
                list[pos] = x;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int j : list) {
            System.out.print(j + "\t");
        }
        System.out.println();
        insertionSort(list);
        System.out.print("Your list after sort: ");
        for (int j : list) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}
