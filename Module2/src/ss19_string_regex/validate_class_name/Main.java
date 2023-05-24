package ss19_string_regex.validate_class_name;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter string: ");
        String className = new Scanner(System.in).nextLine();
        RegexClassName regexClassName = new RegexClassName();
        System.out.println(" Class name " + className + " is " + regexClassName.isClassName(className));
    }
}
