package service.employee;

import model.Employee;

import java.util.List;

public interface IEmployeeService {
    void add(Employee employee);

    List<Employee> findAll();

    List<Employee> findByName(String name);

    List<Employee> findByNameAndID(String name, int id);

    void deleteByID(int id);

    void deleteAllByID(String[] ids);
}
