package ss14_thuat_toan_sap_xep.bai_tap.insertion_sort_step_by_step;

import java.util.Scanner;

public class InsertionSortStepByStep {
    public static void insertionSortStepByStep(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int pos = i, x = list[pos];
            while (pos > 0 && x < list[pos - 1]) {
                System.out.println("-Change " + list[pos] + " in  index " + pos + " to " + list[pos - 1]);
                list[pos] = list[pos - 1];
                pos--;
                System.out.print("List after the change: ");
                for (int num : list) {
                    System.out.print(num + "\t");
                }
                System.out.println();
            }
            if (list[pos]!=x) {
                System.out.println("-Change " + list[pos] + " in  index " + pos + " to " + x);
                list[pos] = x;
            }
            System.out.println("List after the  " + i + "' sort: ");
            for (int num : list) {
                System.out.print(num + "\t");
            }
            System.out.println();
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
        insertionSortStepByStep(list);
    }
}