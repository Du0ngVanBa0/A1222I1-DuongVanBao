package service.customer_type;

import model.CustomerType;
import repository.customer_type.CustomerTypeRepositoryImpl;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService{
    private CustomerTypeRepositoryImpl customerType = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> findALl() {
        return customerType.findAll();
    }

    @Override
    public CustomerType findByID(int id) {
        return customerType.findByID(id);
    }
}
