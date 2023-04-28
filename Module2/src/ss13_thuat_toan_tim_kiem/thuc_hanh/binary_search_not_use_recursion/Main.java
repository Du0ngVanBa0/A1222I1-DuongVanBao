package ss13_thuat_toan_tim_kiem.thuc_hanh.binary_search_not_use_recursion;

public class Main {
    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 11));
        System.out.println(binarySearch(list, 79));
        System.out.println(binarySearch(list, 1));
        System.out.println(binarySearch(list, 5));
        System.out.println(binarySearch(list, 80));
    }

    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static int binarySearch(int[] list, int key) {
        int left = 0;
        int right = list.length - 1;
        while (right >= left) {
            int mid = (left + right) / 2;
            if (list[mid] == key) {
                return mid;
            } else if (list[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
