package ss14_thuat_toan_sap_xep.bai_tap.insertion_sort_step_by_step;

public class InsertionSortStepByStep {
    public static void insertionSortStepByStep(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int pos = i;
            while (pos > 0 && list[pos] < list[pos - 1]) {
                System.out.println("Swap " + list[pos] + " with " + list[pos - 1]);
                int temp = list[pos];
                list[pos] = list[pos - 1];
                list[pos - 1] = temp;
                pos--;
            }
            System.out.println("List after the  " + i + "' sort: ");
            for (int num : list) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    static int[] list = {4, 5, 1, 3, 4, -1, 0, 10, 34, 2, 43, 15};

    public static void main(String[] args) {
        System.out.println("---The beginning list---");
        for (int num : list) {
            System.out.print(num + "\t");
        }
        System.out.println();
        insertionSortStepByStep(list);
    }
}