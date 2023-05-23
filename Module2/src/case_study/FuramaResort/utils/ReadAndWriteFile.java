package case_study.FuramaResort.utils;

import case_study.FuramaResort.model.Customer;
import case_study.FuramaResort.model.Employee;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadAndWriteFile {
    public void writeCustomerFile(String path, Customer customer) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String newLine = customerToStringCSV(customer);
            bw.write(newLine);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
    }

    public void writeEmployeeFile(String path, Employee employee) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String newLine = employeeToStringCSV(employee);
            bw.write(newLine);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
    }

    public void rewriteCustomerFile(String path, List<Customer> customerList) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            for (Customer customer : customerList) {
                bw.write(customerToStringCSV(customer));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
    }

    public void rewriteEmployeeFile(String path, List<Employee> employeeList) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            for (Employee employee : employeeList) {
                bw.write(employeeToStringCSV(employee));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
    }

    private String customerToStringCSV(Customer customer) {
        String str = "";
        str += customer.getFullName() + ",";
        str += getDateString(customer.getDOB()) + ",";
        str += customer.isMale() + ",";
        str += customer.getIdentityCard() + ",";
        str += customer.getPhoneNumber() + ",";
        str += customer.getEmail() + ",";
        str += customer.getCustomerCode() + ",";
        str += customer.getTypeCustomer() + ",";
        str += customer.getAddress();
        return str;
    }

    private String employeeToStringCSV(Employee employee) {
        String str = "";
        str += employee.getFullName() + ",";
        str += getDateString(employee.getDOB()) + ",";
        str += employee.isMale() + ",";
        str += employee.getIdentityCard() + ",";
        str += employee.getPhoneNumber() + ",";
        str += employee.getEmail() + ",";
        str += employee.getEmployeeCode() + ",";
        str += employee.getLevel() + ",";
        str += employee.getPosition() + ",";
        str += employee.getSalary();
        return str;
    }

    public List<Customer> readCustomerFile(String path) {
        List<Customer> customerList = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                customerList.add(readCustomerCsvLine(line));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
        return customerList;
    }

    public List<Employee> readEmployeeFile(String path) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                employeeList.add(readEmployeeCsvLine(line));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
        return employeeList;
    }

    private Customer readCustomerCsvLine(String csv) {
        String[] e = csv.split(",");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dOB = dateFormat.parse(e[1]);
            return new Customer(e[0], dOB, Boolean.parseBoolean(e[2]), e[3], e[4], e[5], e[6], e[7], e[8]);
        } catch (ParseException ex) {
            System.out.println("Wrong date of birth!");
        }
        return null;
    }

    private Employee readEmployeeCsvLine(String csv) {
        String[] e = csv.split(",");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateOfBirth = dateFormat.parse(e[1]);
            return new Employee(e[0], dateOfBirth, Boolean.parseBoolean(e[2]), e[3], e[4], e[5], e[6], e[7], e[8], Integer.parseInt(e[9]));
        } catch (ParseException ex) {
            System.out.println("Wrong date of birth!");
        }
        return null;
    }

    public String getDateString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(date);
    }
}
