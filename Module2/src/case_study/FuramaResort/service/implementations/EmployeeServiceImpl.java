package case_study.FuramaResort.service.implementations;

import case_study.FuramaResort.model.Employee;
import case_study.FuramaResort.repository.implementations.EmployeeRepository;
import case_study.FuramaResort.service.interfaces.IEmployeeService;
import case_study.FuramaResort.utils.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class EmployeeServiceImpl implements IEmployeeService {
    EmployeeRepository<Employee> employeeRepository = new EmployeeRepository<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void edit() {
        do {
            display();
            System.out.print("--Edit Employee--\nEnter Employee's code: ");
            String code = sc.nextLine();
            int index = findCode(code);
            if (index != -1) {
                displayEditEmployeeMenu(index);
                return;
            } else {
                System.out.println("->Error: Can't find Employee's code--");
            }
        } while (true);
    }

    public void displayEditEmployeeMenu(int index) {
        List<Employee> employeeList = employeeRepository.getList();
        Employee employee = employeeList.get(index);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int choice;
        do {
            System.out.printf("--Edit Employee Menu: " + employee.getEmployeeCode() + "--\n" +
                    "1.\tlevel(" + employee.getLevel() + ")\n" +
                    "2.\tposition(" + employee.getPosition() + ")\n" +
                    "3.\tsalary(" + employee.getSalary() + ")\n" +
                    "4.\tfullName(" + employee.getFullName() + ")\n" +
                    "5.\tdOB(" + simpleDateFormat.format(employee.getDOB()) + ")\n" +
                    "6.\tisMale(" + employee.isMale() + ")\n" +
                    "7.\tidentityCard(" + employee.getIdentityCard() + ")\n" +
                    "8.\tphoneNumber(" + employee.getPhoneNumber() + ")\n" +
                    "9.\temail(" + employee.getEmail() + ")\n" +
                    "10.\texit\n" +
                    "Enter your choice(1->10): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 10) {
                    System.out.println("->Error: Only receive number 1->10!");
                } else {
                    switch (choice) {
                        case 1:
                            employeeList.get(index).setLevel(enterLevel());
                            break;
                        case 2:
                            employeeList.get(index).setPosition(enterPosition());
                            break;
                        case 3:
                            employeeList.get(index).setSalary(enterSalary());
                            break;
                        case 4:
                            employeeList.get(index).setFullName(enterFullName());
                            break;
                        case 5:
                            employeeList.get(index).setDOB(enterDOB());
                            break;
                        case 6:
                            employeeList.get(index).setMale(enterIsMale());
                            break;
                        case 7:
                            employeeList.get(index).setIdentityCard(enterIdentityCard());
                            break;
                        case 8:
                            employeeList.get(index).setPhoneNumber(enterPhoneNumber());
                            break;
                        case 9:
                            employeeList.get(index).setEmail(enterEmail());
                            break;
                        case 10:
                            System.out.println("-Exit editing!-");
                            return;
                    }
                    employeeRepository.edit(employeeList);
                    System.out.println("-Edit successfully-");
                    System.out.print("Press 'y' or 'Y' to continue edit this Employee: ");
                    String input = sc.nextLine();
                    if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                        System.out.println("--Continue edit--");
                    } else {
                        return;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    private int findCode(String code) {
        List<Employee> employeeList = employeeRepository.getList();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public String enterLevel() {
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
        switch (valid) {
            case 1:
                return "Trung cap";
            case 2:
                return "Cao dang";
            case 3:
                return "Dai hoc";
            case 4:
                return "Sau dai hoc";
        }
        return null;
    }

    @Override
    public void display() {
        List<Employee> employeeList = employeeRepository.getList();
        System.out.println("--Display Employee List--");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public String enterPosition() {
        int valid = 0;
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
        switch (valid) {
            case 1:
                return "Le tan";
            case 2:
                return "Phuc vu";
            case 3:
                return "Chuyen vien";
            case 4:
                return "Giam sat";
            case 5:
                return "Quan ly";
            case 6:
                return "Giam doc";
        }
        return null;
    }

    public int enterSalary() {
        int salary = 0;
        do {
            System.out.print("Enter Employee's salary: ");
            try {
                salary = Integer.parseInt(sc.nextLine());
                if (salary < 0) {
                    System.out.println("->Error: Salary must be a integer number >=0 ");
                } else {
                    return salary;
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number!");
            }
        } while (true);
    }

    public String enterFullName() {
        String fullName;
        do {
            System.out.print("Enter Employee's full name(Ex: Duong Van Bao): ");
            fullName = sc.nextLine();
            if (new Validation().isName(fullName)) {
                return fullName;
            } else {
                System.out.println("->Error: Wrong format of Employee's full name(Duong Van Bao)");
            }
        } while (true);
    }

    public Date enterDOB() {
        Date dOB;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        do {
            try {
                System.out.print("Enter Employee's day of birth(dd/MM/yyyy): ");
                dOB = dateFormat.parse(sc.nextLine());
                if (dOB.after(new Date())) {
                    System.out.println("->Error: Date of Birth must be before this date!");
                } else if (new Validation().isEnough18Age(dOB)) {
                    return dOB;
                } else {
                    System.out.println("->Error: Customer must be more than 18 years old!");
                }
            } catch (ParseException ex) {
                System.out.println("->Error: Wrong format date(dd/MM/yyyy)!");
            }
        } while (true);
    }

    public boolean enterIsMale() {
        int valid;
        do {
            try {
                System.out.print("Enter Employee's gender:\n1. Male\n2. Female\nEnter number(1 or 2): ");
                valid = Integer.parseInt(sc.nextLine());
                if (valid != 1 && valid != 2) {
                    System.out.println("->Error: Please choose 1 or 2!");
                } else {
                    return (valid == 1);
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    public String enterIdentityCard() {
        String identityCard = "";
        do {
            System.out.print("Enter Employee's Identity Card: ");
            identityCard = sc.nextLine();
            if (new Validation().isIdentityCard(identityCard)) {
                return identityCard;
            } else {
                System.out.println("->Error: Identity card must be a number has 9 or 12 digits");
            }
        } while (true);
    }

    public String enterPhoneNumber() {
        String phoneNumber;
        do {
            System.out.print("Enter Employee's phone number(starting with 0 and having 10 digits): ");
            phoneNumber = sc.nextLine();
            if (new Validation().isPhoneNumber(phoneNumber)) {
                return phoneNumber;
            } else {
                System.out.println("->Error: Phone number must be a number having 10 digits and starting with 0");
            }
        } while (true);
    }

    public String enterEmail() {
        String email;
        do {
            System.out.print("Enter Employee's email(Ex: abc@abc.xyz): ");
            email = sc.nextLine();
            if (new Validation().isEmail(email)) {
                return email;
            } else {
                System.out.println("->Error: Invalid email");
            }
        } while (true);
    }


    @Override
    public void add() {
        String code = "";
        do {
            System.out.print("Enter Employee's code(Ex: NV-1234): ");
            code = sc.nextLine();
            if (new Validation().isEmployeeCode(code)) {
                break;
            } else {
                System.out.println("->Error: Wrong format of Employee's code(NV-1234)");
            }
        } while (true);
        String level = enterLevel();
        String position = enterPosition();
        int salary = enterSalary();
        String fullName = enterFullName();
        Date dOB = enterDOB();
        boolean isMale = enterIsMale();
        String identityCard = enterIdentityCard();
        String phoneNumber = enterPhoneNumber();
        String email = enterEmail();
        employeeRepository.addToList(new Employee(fullName, dOB, isMale, identityCard, phoneNumber, email, code, level, position, salary));
    }
}
