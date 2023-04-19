package ss11_stack_queue.bai_tap.exchange_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("Change decimal number: "+num+" to binary: "+decimalToBinary(num));
    }

    public static String decimalToBinary(int d) {
        Stack<Integer> stack = new Stack<>();
        while (d > 0) {
            stack.push(d % 2);
            d /= 2;
        }
        String result = "";
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
