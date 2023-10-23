package dvb.furama.repository.employee;

import dvb.furama.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
