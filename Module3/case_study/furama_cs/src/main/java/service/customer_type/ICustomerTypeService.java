package service.customer_type;

import model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findALl();
    CustomerType findByID(int id);
}
