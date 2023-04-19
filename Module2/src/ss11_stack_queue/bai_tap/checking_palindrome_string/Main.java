package ss11_stack_queue.bai_tap.checking_palindrome_string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine();
        if (checkPalindrome(input)) {
            System.out.println("This string is a palindrome string");
        } else {
            System.out.println("This string is not a palindrome string");
        }
    }

    public static boolean checkPalindrome(String str) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            String c =  String.valueOf(str.charAt(i)).toLowerCase();
            if (!c.equals(" ")) {
                stack.push(c);
                queue.add(c);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }
        return true;
    }
}
