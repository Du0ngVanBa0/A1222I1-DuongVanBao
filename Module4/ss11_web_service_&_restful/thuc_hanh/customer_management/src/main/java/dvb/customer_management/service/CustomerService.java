package dvb.customer_management.service;

import dvb.customer_management.entity.Customer;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(int id);

    Customer save(Customer customer);

    void remove(Customer customer);
}
