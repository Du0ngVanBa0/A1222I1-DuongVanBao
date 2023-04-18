package ss11_stack_queue.bai_tap.reverse_element_array_slack;

import java.sql.Array;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverseIntArray(intArray);
        for (int e : intArray) {
            System.out.print(e + "  ");
        }
        String string = "  choi  gi nua       hoc            di       ";
        string = reverseString(string);
        System.out.println("\n"+string);
    }

    public static String reverseString(String str) {
        Stack<String> wStack = new Stack<>();
        String newStr = "";
        String[] wArray = splitWord(str);
        for (String e : wArray) {
            wStack.push(e);
        }
        for (int i = 0; i < wArray.length; i++) {
            wArray[i] = wStack.pop();
        }
        for (int i=0;i<wArray.length;i++){
            newStr += wArray[i];
            if (i!= wArray.length-1){
                newStr+=" ";
            }
        }
        return newStr;
    }

    public static String[] splitWord(String str) {
        int count = 0;
        String[] arr = str.split(" ");
        for (String e : arr) {
            if (!e.equals("")) {
                count++;
            }
        }
        String[] wArray = new String[count];
        int index = 0;
        for (String e : arr) {
            if (!e.equals("")) {
                wArray[index] = e;
                index++;
            }
        }
        return wArray;
    }

    public static void reverseIntArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int element : arr) {
            stack.push(element);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }
}
