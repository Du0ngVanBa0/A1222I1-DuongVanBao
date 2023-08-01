package service.employee;

import model.Employee;
import repository.employee.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findByNameAndID(String name, int id) {
        return employeeRepository.findByNameAndID(name, id);
    }

    @Override
    public void deleteByID(int id) {
        employeeRepository.deleteByID(id);
    }

    @Override
    public void deleteAllByID(String[] ids) {
        employeeRepository.deleteAllByID(ids);
    }
}
