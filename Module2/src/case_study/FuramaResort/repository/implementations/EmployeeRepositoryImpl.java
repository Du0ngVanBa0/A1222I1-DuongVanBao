package case_study.FuramaResort.repository.implementations;

import case_study.FuramaResort.model.Employee;
import case_study.FuramaResort.repository.interfaces.IEmployeeRepository;
import case_study.FuramaResort.utils.ReadAndWriteFile;

import java.util.List;

public class EmployeeRepositoryImpl<T> implements IEmployeeRepository<T> {
    static final String EMPLOYEE_PATH;

    static {
        EMPLOYEE_PATH = "E:\\CodeGym\\A1222I1-DuongVanBao\\Module2\\src\\case_study\\FuramaResort\\data\\employee.csv";
    }

    @Override
    public List<T> getList() {
        return (List<T>) new ReadAndWriteFile().readEmployeeFile(EMPLOYEE_PATH);
    }

    @Override
    public void addToList(T employee) {
        new ReadAndWriteFile().writeEmployeeFile(EMPLOYEE_PATH, (Employee) employee);
    }

    @Override
    public void edit(List<T> newList) {
        new ReadAndWriteFile().rewriteEmployeeFile(EMPLOYEE_PATH, (List<Employee>) newList);
    }
}
