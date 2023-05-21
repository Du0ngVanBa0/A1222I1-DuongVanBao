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
        sc = new Scanner(System.in);
    }

    @Override
    public void edit() {

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
        Date dOB = new Date();
        valid = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        do {
            try {
                System.out.print("Enter Employee's day of birth(01/01/2003): ");
                dOB = dateFormat.parse(sc.nextLine());
                valid = 1;
            } catch (ParseException ex) {
                System.out.println("Wrong format date(01/01/2003)!");
            }
        } while (valid == 0);
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
        new ReadAndWriteFile().writeEmployeeFile(employeePath, new Employee(fullName, dOB, isMale, identityCard, phoneNumber, email, code, level, position, salary));
    }
}
