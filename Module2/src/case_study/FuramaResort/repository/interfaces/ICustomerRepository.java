package case_study.FuramaResort.repository.interfaces;

import case_study.FuramaResort.model.Customer;

import java.util.List;

public interface ICustomerRepository<T> extends IRepository<Customer> {
    void edit(List<Customer> newList);
}
