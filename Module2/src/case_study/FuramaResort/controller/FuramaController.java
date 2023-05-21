package case_study.FuramaResort.controller;

import case_study.FuramaResort.service.implementations.EmployeeServiceImpl;
import case_study.FuramaResort.service.interfaces.IEmployeeService;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("--Furama Resort--\n" +
                    "1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n" +
                    "Enter your choice(1->6): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 6) {
                    System.out.println("->Error: Only receive number 1->6!");
                } else {
                    switch (choice) {
                        case 1:
                            displayEmployeeMenu();
                            break;
                        case 2:
                            displayCustomerMenu();
                            break;
                        case 3:
                            displayFacilityMenu();
                            break;
                        case 4:
                            displayBookingMenu();
                            break;
                        case 5:
                            displayPromotionMenu();
                            break;
                        case 6:
                            System.out.println("---End program---");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (choice != 6);
    }

    public static void displayPromotionMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n" +
                    "Enter your choice(1->3): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("->Error: Only receive number 1->3!");
                } else {
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
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

    public static void displayBookingMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new contract\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "6.\tReturn main menu\n" +
                    "Enter your choice(1->6): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 6) {
                    System.out.println("->Error: Only receive number 1->6!");
                } else {
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 6:
                            System.out.println("---Return main menu---");
                            return;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    public static void displayFacilityMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn main menu\n" +
                    "Enter your choice(1->4): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 4) {
                    System.out.println("->Error: Only receive number 1->4!");
                } else {
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            System.out.println("---Return main menu---");
                            return;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    public static void displayCustomerMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n" +
                    "Enter your choice(1->4): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 4) {
                    System.out.println("->Error: Only receive number 1->4!");
                } else {
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            System.out.println("---Return main menu---");
                            return;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    public static void displayEmployeeMenu() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n" +
                    "Enter your choice(1->4): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 4) {
                    System.out.println("->Error: Only receive number 1->4!");
                } else {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    switch (choice) {
                        case 1:
                            employeeService.display();
                            break;
                        case 2:
                            employeeService.add();
                            break;
                        case 3:
                            break;
                        case 4:
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
