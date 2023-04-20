package ss11_stack_queue.bai_tap.checking_bracket_stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String to check bracket: ");
        String input = sc.nextLine();
        if (checkOptimalBracket(input)) {
            System.out.println("Well");
        } else {
            System.out.println("???");
        }
    }

    public static boolean checkOptimalBracket(String str) {
        String newStr = "";
        for (int i = 0; i < str.length() - 1; i++) {
            newStr += str.charAt(i + 1);
        }
        return checkBracket(str) && checkBracket(newStr);
    }

    public static boolean checkBracket(String str) {
        Stack<String> bStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char sym = str.charAt(i);
            if (sym == '(') {
                bStack.push(String.valueOf(sym));
            } else if (sym == ')') {
                if (bStack.isEmpty()) {
                    return false;
                }
                String left = bStack.pop();
                if (left == null) {
                    return false;
                }
            }
        }
        if (bStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
