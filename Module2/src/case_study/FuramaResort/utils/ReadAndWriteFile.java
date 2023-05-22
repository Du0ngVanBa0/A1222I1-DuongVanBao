package case_study.FuramaResort.utils;

import case_study.FuramaResort.model.Employee;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadAndWriteFile {
    public void writeEmployeeFile(String path, Employee employee) {
        try {
            File file = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String newLine = employeeToString(employee);
            bw.newLine();
            bw.write(newLine);
            bw.close();
        } catch (IOException e) {
            System.out.println("File không tồn tại hoặc đã xảy ra lỗi!");
        }
    }

    public String employeeToString(Employee employee) {
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
            System.out.println("File không tồn tại hoặc đã xảy ra lỗi!");
        }
        return employeeList;
    }

    public Employee readEmployeeCsvLine(String csv) {
        String[] e = csv.split(",");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateOfBirth = dateFormat.parse(e[1]);
            return new Employee(e[0], dateOfBirth, Boolean.parseBoolean(e[2]), e[3], e[4], e[5], e[6], e[7], e[8], Integer.parseInt(e[9]));
        } catch (ParseException ex) {
            System.out.println("Ngày sinh sai định dạng!");
        }
        return null;
    }

    public String getDateString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(date);
    }
}
