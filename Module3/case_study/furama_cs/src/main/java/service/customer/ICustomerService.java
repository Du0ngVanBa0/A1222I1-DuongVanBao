package service.customer;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    void add(Customer customer);

    List<Customer> findAll();

    void deleteByID(int id);

    Customer findByID(int id);
    void edit(Customer customer);
    int countAll();
    List<Customer> findAllWithPaging(int page, int record);
    List<Customer> findAllByName(String str, int page, int record);
}
