package case_study.FuramaResort.repository.implementations;

import case_study.FuramaResort.model.Customer;
import case_study.FuramaResort.repository.interfaces.ICustomerRepository;
import case_study.FuramaResort.utils.ReadAndWriteFile;

import java.util.List;

public class CustomerRepositoryImpl<T> implements ICustomerRepository<T> {
    static final String CUSTOMER_PATH;

    static {
        CUSTOMER_PATH = "E:\\CodeGym\\A1222I1-DuongVanBao\\Module2\\src\\case_study\\FuramaResort\\data\\customer.csv";

    }

    @Override
    public List<T> getList() {
        return (List<T>) new ReadAndWriteFile().readCustomerFile(CUSTOMER_PATH);
    }

    @Override
    public void addToList(T customer) {
        new ReadAndWriteFile().writeCustomerFile(CUSTOMER_PATH, (Customer) customer);
    }

    @Override
    public void edit(List<T> newList) {
        new ReadAndWriteFile().rewriteCustomerFile(CUSTOMER_PATH, (List<Customer>) newList);
    }
}
