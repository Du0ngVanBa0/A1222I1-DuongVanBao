package ss14_thuat_toan_sap_xep.thuc_hanh.selection_sort;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void main(String[] args) {
        selectionSort(list);
        for (double num : list) {
            System.out.print(num + "\t");
        }
    }

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length; i++) {
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[minIndex]) {
                    minIndex = k;
                }
            }
            if (minIndex!=i) {
                double temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
        }
    }
}
