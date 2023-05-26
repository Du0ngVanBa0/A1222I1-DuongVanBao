package case_study.FuramaResort.repository.implementations;

import case_study.FuramaResort.model.Customer;
import case_study.FuramaResort.repository.interfaces.ICustomerRepository;
import case_study.FuramaResort.utils.ReadAndWriteFile;

import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository<Customer> {
    static final String CUSTOMER_PATH;

    static {
        CUSTOMER_PATH = "E:\\CodeGym\\A1222I1-DuongVanBao\\Module2\\src\\case_study\\FuramaResort\\data\\customer.csv";

    }

    @Override
    public List<Customer> getList() {
        return new ReadAndWriteFile().readCustomerFile(CUSTOMER_PATH);
    }

    @Override
    public void addNew(Customer customer) {
        new ReadAndWriteFile().writeCustomerFile(CUSTOMER_PATH, customer);
    }

    @Override
    public void edit(List<Customer> newList) {
        new ReadAndWriteFile().rewriteCustomerFile(CUSTOMER_PATH, newList);
    }
}
