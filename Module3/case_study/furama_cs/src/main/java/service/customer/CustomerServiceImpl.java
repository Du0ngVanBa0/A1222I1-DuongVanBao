package service.customer;

import model.Customer;
import repository.customer.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteByID(int id) {
        customerRepository.deleteByID(id);
    }

    @Override
    public Customer findByID(int id) {
        return customerRepository.findByID(id);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.edit(customer);
    }

    @Override
    public int countAll() {
        return customerRepository.countAll();
    }

    @Override
    public List<Customer> findAllWithPaging(int page, int record) {
        return customerRepository.findAllWithPaging(page, record);
    }

    @Override
    public List<Customer> findAllByName(String str, int page, int record) {
        return customerRepository.findAllByName(str, page, record);
    }
}
