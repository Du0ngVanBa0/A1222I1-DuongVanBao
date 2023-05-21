package case_study.FuramaResort.service.implementations;

import case_study.FuramaResort.repository.implementations.EmployeeRepository;
import case_study.FuramaResort.service.interfaces.IEmployeeService;


public class EmployeeServiceImpl implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        employeeRepository.display();
    }

    @Override
    public void add() {
        employeeRepository.add();
    }
}
