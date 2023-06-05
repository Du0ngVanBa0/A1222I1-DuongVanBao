package final_exam.controller;

import final_exam.service.Implements.PhoneChinhHangServiceImpl;
import final_exam.service.Implements.PhoneXachTayServiceImpl;

import java.util.Scanner;

public class PhoneController {

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Chọn chức năng theo số(để tiếp tục):\n" +
                    "1.\tThêm mới\n" +
                    "2.\tXóa\n" +
                    "3.\tXem danh sách điện thoại\n" +
                    "4.\tTìm kiếm\n" +
                    "5.\tThoát\n" +
                    "Chọn chức năng: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 5) {
                    System.out.println("->Lỗi: Chỉ nhận số từ 1 đến 5!");
                } else {
                    PhoneChinhHangServiceImpl phoneChinhHangService = new PhoneChinhHangServiceImpl();
                    PhoneXachTayServiceImpl phoneXachTayService = new PhoneXachTayServiceImpl();
                    switch (choice) {
                        case 1:
                            displayAddMenu();
                            break;
                        case 2:
                            displayDeleteMenu();
                            break;
                        case 3:
                            phoneXachTayService.display();
                            phoneChinhHangService.display();
                            break;
                        case 4:
                            displaySearchMenu();
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Lỗi: Vui lòng nhập số nguyên dương theo yêu cầu để tiếp tục!");
            }
        } while (choice != 5);
    }

    public static void displaySearchMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1.\tTìm Phone chính hãng\n" +
                    "2.\tTìm Phone Xách Tay\n" +
                    "3.\tReturn main menu\n" +
                    "Enter your choice(1->3): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("->Error: Only receive number 1->3!");
                } else {
                    PhoneChinhHangServiceImpl phoneChinhHangService = new PhoneChinhHangServiceImpl();
                    PhoneXachTayServiceImpl phoneXachTayService = new PhoneXachTayServiceImpl();
                    switch (choice) {
                        case 1:
                            phoneChinhHangService.search();
                            break;
                        case 2:
                            phoneXachTayService.search();
                            break;
                        case 3:
                            System.out.println("---Return main menu---");
                            return;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    public static void displayAddMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1.\tThêm Phone chính hãng\n" +
                    "2.\tThêm Phone Xách Tay\n" +
                    "3.\tReturn main menu\n" +
                    "Enter your choice(1->3): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("->Error: Only receive number 1->3!");
                } else {
                    PhoneChinhHangServiceImpl phoneChinhHangService = new PhoneChinhHangServiceImpl();
                    PhoneXachTayServiceImpl phoneXachTayService = new PhoneXachTayServiceImpl();
                    switch (choice) {
                        case 1:
                            phoneChinhHangService.add();
                            break;
                        case 2:
                            phoneXachTayService.add();
                            break;
                        case 3:
                            System.out.println("---Return main menu---");
                            return;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    public static void displayDeleteMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1.\tXóa Phone chính hãng\n" +
                    "2.\tXóa Phone Xách Tay\n" +
                    "3.\tReturn main menu\n" +
                    "Enter your choice(1->3): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("->Error: Only receive number 1->3!");
                } else {
                    PhoneChinhHangServiceImpl phoneChinhHangService = new PhoneChinhHangServiceImpl();
                    PhoneXachTayServiceImpl phoneXachTayService = new PhoneXachTayServiceImpl();
                    switch (choice) {
                        case 1:
                            phoneChinhHangService.delete();
                            break;
                        case 2:
                            phoneXachTayService.delete();
                            break;
                        case 3:
                            System.out.println("---Return main menu---");
                            return;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }
}
