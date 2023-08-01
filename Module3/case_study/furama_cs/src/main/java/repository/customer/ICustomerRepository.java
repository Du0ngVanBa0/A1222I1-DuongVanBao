package repository.customer;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    void add(Customer customer);

    List<Customer> findAll();

    void deleteByID(int id);
    Customer findByID(int id);
    void edit(Customer customer);
    List<Customer> findAllWithPaging(int page, int record);
    int countAll();
    List<Customer> findAllByName(String name, int page, int record);
}
