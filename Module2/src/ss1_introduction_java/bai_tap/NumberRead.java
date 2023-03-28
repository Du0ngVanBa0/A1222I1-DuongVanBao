package ss1_introduction_java.bai_tap;

import java.util.Scanner;

public class NumberRead {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a integer number (<=999)");
        int num = sc.nextInt();
        String result = "";
        if (num < 0 || num > 999) {
            result = "out of ability";
        } else if (num < 10) {
            switch (num) {
                case 0:
                    result = "zero";
                    break;
                case 1:
                    result = "one";
                    break;
                case 2:
                    result = "two";
                    break;
                case 3:
                    result = "three";
                    break;
                case 4:
                    result = "four";
                    break;
                case 5:
                    result = "five";
                    break;
                case 6:
                    result = "six";
                    break;
                case 7:
                    result = "seven";
                    break;
                case 8:
                    result = "eight";
                    break;
                case 9:
                    result = "nine";
                    break;
            }
        } else if (num < 20) {
            result = joinTens(result, num);
        } else if (num < 100) {
            int tens = num / 10;
            int ones = num % 10;
            switch (tens) {
                case 2:
                    result = "twenty";
                    break;
                case 3:
                    result = "thirty";
                    break;
                case 4:
                    result = "fourty";
                    break;
                case 5:
                    result = "fifty";
                    break;
                case 6:
                    result = "sixty";
                    break;
                case 7:
                    result = "seventy";
                    break;
                case 8:
                    result = "eighty";
                    break;
                case 9:
                    result = "ninety";
                    break;
            }
            result = joinOnes(result, ones);
        } else {
            int hundreds = num / 100;
            int tens = (num % 100) / 10;
            int ones = num % 10;
            switch (hundreds) {
                case 1:
                    result = "one hundred";
                    break;
                case 2:
                    result = "two hundred";
                    break;
                case 3:
                    result = "three hundred";
                    break;
                case 4:
                    result = "four hundred";
                    break;
                case 5:
                    result = "five hundred";
                    break;
                case 6:
                    result = "six hundred";
                    break;
                case 7:
                    result = "seven hundred";
                    break;
                case 8:
                    result = "eight hundred";
                    break;
                case 9:
                    result = "nine hundred";
                    break;
            }
            switch (tens) {
                case 1:
                    result = joinTens(result, (num % 100));
                    break;
                case 2:
                    result += " twenty";
                    break;
                case 3:
                    result += " thirty";
                    break;
                case 4:
                    result += " fourty";
                    break;
                case 5:
                    result += " fifty";
                    break;
                case 6:
                    result += " sixty";
                    break;
                case 7:
                    result += " seventy";
                    break;
                case 8:
                    result += " eighty";
                    break;
                case 9:
                    result += " ninety";
                    break;
            }
            if (tens != 1) {
                result = joinOnes(result, ones);
            }
        }
        System.out.print(result);
    }

    private static String joinTens(String result, int ones) {
        switch (ones) {
            case 10:
                result += " ten";
                break;
            case 11:
                result += " eleven";
                break;
            case 12:
                result += " twelve";
                break;
            case 13:
                result += " thirteen";
                break;
            case 14:
                result += " fourteen";
                break;
            case 15:
                result += " fifteen";
                break;
            case 16:
                result += " sixteen";
                break;
            case 17:
                result += " seventeen";
                break;
            case 18:
                result += " eighteen";
                break;
            case 19:
                result += " nineteen";
                break;
        }
        return result;
    }

    private static String joinOnes(String result, int ones) {
        switch (ones) {
            case 0:
                break;
            case 1:
                result += " one";
                break;
            case 2:
                result += " two";
                break;
            case 3:
                result += " three";
                break;
            case 4:
                result += " four";
                break;
            case 5:
                result += " five";
                break;
            case 6:
                result += " six";
                break;
            case 7:
                result += " seven";
                break;
            case 8:
                result += " eight";
                break;
            case 9:
                result += " nine";
                break;
        }
        return result;
    }
}