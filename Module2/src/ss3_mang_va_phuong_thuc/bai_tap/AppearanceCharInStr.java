package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class AppearanceCharInStr {
    public static void main(String[] args) {
        int count = 0;
        String str = "Sakurairo maukoro, watashi wa hitori Osae kirenu mune ni tachi tsuku shiteta";
        System.out.printf("String: %s\n",str);
        System.out.print("Enter a character to count in this string: ");
        char find = (new Scanner(System.in)).next().charAt(0);
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==find){
                count++;
            }
        }
        System.out.printf("Char '%c' has appear %d time(s) in this String",find,count);
    }
}
