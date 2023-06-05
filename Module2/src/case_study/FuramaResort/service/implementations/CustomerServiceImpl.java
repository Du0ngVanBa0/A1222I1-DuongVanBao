package case_study.FuramaResort.service.implementations;

import case_study.FuramaResort.model.Customer;
import case_study.FuramaResort.repository.implementations.CustomerRepositoryImpl;
import case_study.FuramaResort.service.interfaces.ICustomerService;
import case_study.FuramaResort.utils.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        String code = enterCode();
        String type = enterType();
        String fullName = enterFullName();
        Date dOB = enterDOB();
        boolean isMale = enterIsMale();
        String identityCard = enterIdentityCard();
        String phoneNumber = enterPhoneNumber();
        String email = enterEmail();
        String address = enterAddress();
        customerRepository.addNew(new Customer(fullName, dOB, isMale, identityCard, phoneNumber, email, code, type, address));
        System.out.println("-Add successfully-");
    }

    private String enterCode() {
        String code = "";
        boolean valid = false;
        do {
            System.out.print("Enter Customer's code(Ex: KH-1234): ");
            code = sc.nextLine();
            if (new Validation().isCustomerCode(code)) {
                valid = true;
                List<Customer> customerList = customerRepository.getList();
                for (Customer customer : customerList) {
                    if (customer.getCustomerCode().equals(code)) {
                        System.out.println("This Customer's code already exist!");
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    return code;
                }
            } else {
                System.out.println("->Error: Wrong format of Customer's code(KH-1234)");
            }
        } while (true);
    }

    @Override
    public void edit() {
        do {
            display();
            System.out.print("--Edit Customer--\nEnter Customer's code: ");
            String code = sc.nextLine();
            int index = findCode(code);
            if (index != -1) {
                displayEditCustomerMenu(index);
                return;
            } else {
                System.out.println("->Error: Can't find Customer's code--");
            }
        } while (true);
    }

    @Override
    public void display() {
        List<Customer> customerList = customerRepository.getList();
        System.out.println("--Display Customer List--");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    private void displayEditCustomerMenu(int index) {
        List<Customer> customerList = customerRepository.getList();
        Customer customer = customerList.get(index);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int choice;
        do {
            System.out.printf("--Edit Customer Menu: " + customer.getCustomerCode() + "--\n" +
                    "1.\tlevel(" + customer.getTypeCustomer() + ")\n" +
                    "2.\tposition(" + customer.getAddress() + ")\n" +
                    "3.\tfullName(" + customer.getFullName() + ")\n" +
                    "4.\tdOB(" + simpleDateFormat.format(customer.getDOB()) + ")\n" +
                    "5.\tisMale(" + customer.isMale() + ")\n" +
                    "6.\tidentityCard(" + customer.getIdentityCard() + ")\n" +
                    "7.\tphoneNumber(" + customer.getPhoneNumber() + ")\n" +
                    "8.\temail(" + customer.getEmail() + ")\n" +
                    "9.\texit\n" +
                    "Enter your choice(1->9): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 9) {
                    System.out.println("->Error: Only receive number 1->9!");
                } else {
                    switch (choice) {
                        case 1:
                            customerList.get(index).setTypeCustomer(enterType());
                            break;
                        case 2:
                            customerList.get(index).setAddress(enterAddress());
                            break;
                        case 3:
                            customerList.get(index).setFullName(enterFullName());
                            break;
                        case 4:
                            customerList.get(index).setDOB(enterDOB());
                            break;
                        case 5:
                            customerList.get(index).setMale(enterIsMale());
                            break;
                        case 6:
                            customerList.get(index).setIdentityCard(enterIdentityCard());
                            break;
                        case 7:
                            customerList.get(index).setPhoneNumber(enterPhoneNumber());
                            break;
                        case 8:
                            customerList.get(index).setEmail(enterEmail());
                            break;
                        case 9:
                            System.out.println("-Exit editing!-");
                            return;
                    }
                    customerRepository.edit(customerList);
                    System.out.println("-Edit successfully-");
                    System.out.print("Press 'y' or 'Y' to continue edit this Customer: ");
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
        List<Customer> customerList = customerRepository.getList();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    private String enterAddress() {
        System.out.print("Enter Customer's address: ");
        return sc.nextLine();
    }

    private String enterType() {
        int valid = 0;
        do {
            try {
                System.out.print("Enter Customer's type:\n1. Diamond\n2. Platinum\n3. Gold\n4. Silver\n5. Member\nEnter number(1->5): ");
                valid = Integer.parseInt(sc.nextLine());
                if (valid != 1 && valid != 2 && valid != 3 && valid != 4 && valid != 5) {
                    System.out.println("->Error: Only receive number 1->5!");
                } else {
                    switch (valid) {
                        case 1:
                            return "Diamond";
                        case 2:
                            return "Platinum";
                        case 3:
                            return "Gold";
                        case 4:
                            return "Silver";
                        case 5:
                            return "Member";
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    private String enterFullName() {
        String fullName;
        do {
            System.out.print("Enter Customer's full name(Ex: Duong Van Bao): ");
            fullName = sc.nextLine();
            if (new Validation().isFullName(fullName)) {
                return fullName;
            } else {
                System.out.println("->Error: Wrong format of Customer's full name(Duong Van Bao)");
            }
        } while (true);
    }

    private Date enterDOB() {
        Date dOB;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        do {
            try {
                System.out.print("Enter Customer's day of birth(dd/MM/yyyy): ");
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

    private boolean enterIsMale() {
        int valid;
        do {
            try {
                System.out.print("Enter Customer's gender:\n1. Male\n2. Female\nEnter number(1 or 2): ");
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

    private String enterIdentityCard() {
        String identityCard = "";
        do {
            System.out.print("Enter Customer's Identity Card(a number has 9 or 12 digits): ");
            identityCard = sc.nextLine();
            if (new Validation().isIdentityCard(identityCard)) {
                return identityCard;
            } else {
                System.out.println("->Error: Identity card must be a number has 9 or 12 digits");
            }
        } while (true);
    }

    private String enterPhoneNumber() {
        String phoneNumber;
        do {
            System.out.print("Enter Customer's phone number(starting with 0 and having 10 digits): ");
            phoneNumber = sc.nextLine();
            if (new Validation().isPhoneNumber(phoneNumber)) {
                return phoneNumber;
            } else {
                System.out.println("->Error: Phone number must be a number having 10 digits and starting with 0");
            }
        } while (true);
    }

    private String enterEmail() {
        String email;
        do {
            System.out.print("Enter Customer's email(Ex: abc@abc.xyz): ");
            email = sc.nextLine();
            if (new Validation().isEmail(email)) {
                return email;
            } else {
                System.out.println("->Error: Invalid email");
            }
        } while (true);
    }
}
