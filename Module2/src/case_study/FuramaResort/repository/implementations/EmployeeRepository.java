package case_study.FuramaResort.repository.implementations;

import case_study.FuramaResort.model.Employee;
import case_study.FuramaResort.service.interfaces.IEmployeeService;
import case_study.FuramaResort.utils.ReadAndWriteFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepository implements IEmployeeService {
    static List<Employee> employeeList;
    static Scanner sc;
    static String employeePath;

    static {
        employeePath = "E:\\CodeGym\\A1222I1-DuongVanBao\\Module2\\src\\case_study\\FuramaResort\\data\\employee.csv";
        employeeList = (new ReadAndWriteFile().readEmployeeFile(employeePath));
        sc = new Scanner(System.in);
    }

    @Override
    public void edit() {
        System.out.print("--Edit Employee--\nEnter Employee's code: ");
        String code = sc.nextLine();
        int index = findCode(code);
        if (index != -1) {
            System.out.printf("--Edit employee's code: %s --\n", code);

        } else {
            System.out.println("--Can't find Employee's code--");
        }
    }

    private int findCode(String code) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        employeeList = (new ReadAndWriteFile().readEmployeeFile(employeePath));
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void add() {
        System.out.print("Enter Employee's code: ");
        String code = sc.nextLine();
        int valid = 0;
        do {
            try {
                System.out.print("Enter Employee's level:\n1. Trung cap\n2. Cao Dang\n3. Dai hoc\n4. Sau dai hoc\nEnter number(1->4): ");
                valid = Integer.parseInt(sc.nextLine());
                if (valid != 1 && valid != 2 && valid != 3 && valid != 4) {
                    System.out.println("->Error: Only receive number 1->4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
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
        valid = 0;
        do {
            try {
                System.out.print("Enter Employee's position:\n1. Le tan\n2. Phuc vu\n3. Chuyen vien\n4. Giam sat\n5. Quan ly\n6. Giam doc\nEnter number(1->6): ");
                valid = Integer.parseInt(sc.nextLine());
                if (valid != 1 && valid != 2 && valid != 3 && valid != 4 && valid != 5 && valid != 6) {
                    System.out.println("->Error: Only receive number 1->6!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
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
        valid = 0;
        int salary = 0;
        do {
            System.out.print("Enter Employee's salary: ");
            try {
                salary = Integer.parseInt(sc.nextLine());
                if (salary < 0) {
                    System.out.println("->Error: Salary must be a integer number >=0 ");
                }
                valid = 1;
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number!");
            }
        } while (valid == 0 || salary < 0);
        System.out.print("Enter Employee's full name: ");
        String fullName = sc.nextLine();
        Date dOB = new Date();
        valid = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        do {
            try {
                System.out.print("Enter Employee's day of birth(dd/MM/yyyy): ");
                dOB = dateFormat.parse(sc.nextLine());
                if (dOB.after(new Date())) {
                    System.out.println("->Error: Date of Birth must be before this date");
                } else {
                    valid = 1;
                }
            } catch (ParseException ex) {
                System.out.println("->Error: Wrong format date(dd/MM/yyyy)!");
            }
        } while (valid == 0);
        valid = 0;
        do {
            try {
                System.out.print("Enter Employee's gender:\n1. Male\n2. Female\nEnter number(1 or 2): ");
                valid = Integer.parseInt(sc.nextLine());
                if (valid != 1 && valid != 2) {
                    System.out.println("->Error: Please choose 1 or 2!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (valid != 1 && valid != 2);
        boolean isMale = (valid == 1);
        System.out.print("Enter Employee's identity card: ");
        String identityCard = sc.nextLine();
        System.out.print("Enter Employee's phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter Employee's email: ");
        String email = sc.nextLine();
        new ReadAndWriteFile().writeEmployeeFile(employeePath, new Employee(fullName, dOB, isMale, identityCard, phoneNumber, email, code, level, position, salary));
    }
}
