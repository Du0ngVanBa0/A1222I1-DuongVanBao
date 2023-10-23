package dvb.furama.service.customer;

import dvb.furama.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAllPaging(Pageable pageable);

    Page<Customer> findAllByName(String name, Pageable pageable);

    void deleteById(int id);

    Optional<Customer> findById(int id);

    void save(Customer customer);

    List<Customer> findAll();
}
