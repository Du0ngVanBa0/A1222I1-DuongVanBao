package ss4_lop_va_doi_tuong_trong_java.bai_tap.stop_watch;

public class Main {
    public static void main(String[] args) {
        StopWatch sw1 = new StopWatch();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sw1.start();
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }
        }
        sw1.stop();
        System.out.println("\nNew Arr:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.printf("\nTime cost: %d millisecond", sw1.getElapsedTime());
    }
}
