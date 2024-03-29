package repository.customer_type;

import model.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> findAll();
    CustomerType findByID(int id);
}
