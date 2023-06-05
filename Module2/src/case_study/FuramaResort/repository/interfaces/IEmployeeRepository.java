package case_study.FuramaResort.repository.interfaces;

import case_study.FuramaResort.model.Employee;

import java.util.List;

public interface IEmployeeRepository<T> extends IRepository<Employee> {
    void edit(List<Employee> newList);
}
