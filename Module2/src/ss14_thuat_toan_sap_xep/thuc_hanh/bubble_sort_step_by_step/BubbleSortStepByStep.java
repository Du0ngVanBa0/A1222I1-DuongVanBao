package ss14_thuat_toan_sap_xep.thuc_hanh.bubble_sort_step_by_step;

import java.util.Scanner;

public class BubbleSortStepByStep {
    static int[] lst = {1, 0, -1, 54, 13, 54, 24, 14, 7, 6, 32};

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
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        bubbleSortStepByStep(list);
    }

    public static void bubbleSortStepByStep(int[] list) {
        boolean needNextPass = true;
        for (int i = 1; i < list.length; i++) {
            needNextPass = false;
            for (int k = list.length - 1; k >= i; k--) {
                if (list[k] < list[k - 1]) {
                    System.out.println("Swap " + list[k] + " with " + list[k - 1]);
                    int temp = list[k];
                    list[k] = list[k - 1];
                    list[k - 1] = temp;
                    needNextPass = true;
                }
            }
            if (!needNextPass) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            /* Show the list after sort */
            System.out.print("List after the  " + i + "' sort: ");
            for (int k : list) {
                System.out.print(k + "\t");
            }
            System.out.println();
        }
    }
}
