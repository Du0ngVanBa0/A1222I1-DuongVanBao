package dvb.furama.service.employee;

import dvb.furama.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAllPaging(Pageable pageable);

    Page<Employee> findAllByName(String name, Pageable pageable);

    void deleteById(int id);
    Optional<Employee> findById(int id);

    void save(Employee customer);

    List<Employee> findAll();
}
