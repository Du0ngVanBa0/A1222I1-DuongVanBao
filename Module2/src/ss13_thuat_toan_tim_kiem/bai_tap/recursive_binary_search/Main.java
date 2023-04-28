package ss13_thuat_toan_tim_kiem.bai_tap.recursive_binary_search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 5, 6, 8, 23, 45, 65, 67, 96, 125};
        System.out.print("Enter a number to search: ");
        int search = Integer.parseInt(sc.nextLine());
        System.out.print("Search " + search + " in the array: " + binarySearch(arr, 0, arr.length - 1, search));
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        if (right >= left) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                return binarySearch(array, left, middle - 1, value);
            } else {
                return binarySearch(array, middle + 1, right, value);
            }
        } else {
            return -1;
        }
    }
}
