package ss2_vong_lap_trong_java.bai_tap;

public class PrimeLess100 {
    public static void main(String[] args) {
        for (int i=2;i<=100;i++){
            if (isPrime(i)){
                System.out.print(i+"    ");
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
