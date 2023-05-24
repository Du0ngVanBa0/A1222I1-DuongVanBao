package ss19_string_regex.validate_phone_number;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter string: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        RegexPhoneNumber regexPhoneNumber = new RegexPhoneNumber();
        System.out.println(" Class name " + phoneNumber + " is " + regexPhoneNumber.isPhoneNumber(phoneNumber));
    }
}
