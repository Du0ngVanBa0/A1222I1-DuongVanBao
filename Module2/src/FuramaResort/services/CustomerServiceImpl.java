package FuramaResort.services;

import FuramaResort.models.Customer;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    static LinkedList<Customer> customerList;
    static Scanner sc;

    static {
        customerList = new LinkedList<>();
        sc = new Scanner(System.in);
    }

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void add() {
//        System.out.println("--Add new Customer--");
        System.out.print("Enter Customer's code: ");
        String code = sc.nextLine();
        int valid;
        System.out.print("Enter Customer's type: ");
        do {
            System.out.print("Enter Employee's type:\n1. Diamond\n2. Platinum\n3. Gold\n4. Silver\n5. Member\nEnter number(1->5): ");
            valid = Integer.parseInt(sc.nextLine());
        } while (valid != 1 && valid != 2 && valid != 3 && valid != 4 && valid != 5);
        String type = "";
        switch (valid) {
            case 1:
                type = "Diamond";
                break;
            case 2:
                type = "Platinum";
                break;
            case 3:
                type = "Gold";
                break;
            case 4:
                type = "Silver";
                break;
            case 5:
                type = "Member";
                break;
        }
        System.out.print("Enter Customer's full name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter Customer's address: ");
        String address = sc.nextLine();
        System.out.print("Enter Customer's day of birth: ");
        String dOB = sc.nextLine();
        do {
            System.out.print("Enter Customer's gender:\n1. Male\n2. Female\nEnter number(1 or 2): ");
            valid = Integer.parseInt(sc.nextLine());
        } while (valid != 1 && valid != 2);
        boolean isMale = (valid == 1);
        System.out.print("Enter Customer's identity card: ");
        String identityCard = sc.nextLine();
        System.out.print("Enter Customer's phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter Customer's email: ");
        String email = sc.nextLine();
        customerList.add(new Customer(fullName, dOB, isMale, identityCard, phoneNumber, email, code, type, address));
    }

    public void edit() {
        System.out.println("--Edit Customer--");
        System.out.print("Enter Customer's code: ");
        String code = sc.nextLine();
        int index = findCode(code);
        if (index != -1) {
            System.out.printf("--Edit employee's code: %s --\n", code);
            add();
        } else {
            System.out.println("--Can't find Customer's code--");
        }
    }

    public int findCode(String code) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }
}