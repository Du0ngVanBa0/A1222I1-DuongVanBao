package FuramaResort.services;

import FuramaResort.models.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static ArrayList<Employee> employeeList;
    static Scanner sc;

    static {
        employeeList = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    @Override
    public void display() {
//        System.out.println("--Display Employee List--");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void add() {
//        System.out.println("--Add new Employee--");
        System.out.print("Enter Employee's code: ");
        String code = sc.nextLine();
        int valid;
        do {
            System.out.print("Enter Employee's level:\n1. Trung cap\n2. Cao Dang\n3. Dai hoc\n4. Sau dai hoc\nEnter number(1->4): ");
            valid = Integer.parseInt(sc.nextLine());
        } while (valid != 1 && valid != 2 && valid != 3 && valid != 4);
        String level = "";
        switch (valid) {
            case 1:
                level = "Trung cap";
                break;
            case 2:
                level = "Cao dang";
                break;
            case 3:
                level = "Dai hoc";
                break;
            case 4:
                level = "Sau dai hoc";
                break;
        }
        do {
            System.out.print("Enter Employee's position:\n1. Le tan\n2. Phuc vu\n3. Chuyen vien\n4. Giam sat\n5. Quan ly\n6. Giam doc\nEnter number(1->5): ");
            valid = Integer.parseInt(sc.nextLine());
        } while (valid != 1 && valid != 2 && valid != 3 && valid != 4 && valid != 5 && valid != 6);
        String position = "";
        switch (valid) {
            case 1:
                position = "Le tan";
                break;
            case 2:
                position = "Phuc vu";
                break;
            case 3:
                position = "Chuyen vien";
                break;
            case 4:
                position = "Giam sat";
                break;
            case 5:
                position = "Quan ly";
                break;
            case 6:
                position = "Giam doc";
                break;
        }
        System.out.print("Enter Employee's salary: ");
        int salary = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Employee's full name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter Employee's day of birth: ");
        String dOB = sc.nextLine();
        do {
            System.out.print("Enter Employee's gender:\n1. Male\n2. Female\nEnter number(1 or 2): ");
            valid = Integer.parseInt(sc.nextLine());
        } while (valid != 1 && valid != 2);
        boolean isMale = (valid == 1);
        System.out.print("Enter Employee's identity card: ");
        String identityCard = sc.nextLine();
        System.out.print("Enter Employee's phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter Employee's email: ");
        String email = sc.nextLine();
        employeeList.add(new Employee(fullName, dOB, isMale, identityCard, phoneNumber, email, code, level, position, salary));
    }

    public void edit() {
        System.out.println("--Edit Employee--");
        System.out.print("Enter Employee's code: ");
        String code = sc.nextLine();
        int index = findCode(code);
        if (index != -1) {
            System.out.printf("--Edit employee's code: %s --\n", code);
            add();
        } else {
            System.out.println("--Can't find Employee's code--");
        }
    }

    public int findCode(String code) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }
}
