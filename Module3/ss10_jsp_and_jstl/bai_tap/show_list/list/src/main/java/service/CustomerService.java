package service;

import entities.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    private static Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer("Name", "12/09/2003", "Da Nang", "img/worker.jpg"));
        customerMap.put(2, new Customer("Name", "12/09/2003", "Da Nang", "img/worker.jpg"));
        customerMap.put(3, new Customer("Name", "12/09/2003", "Da Nang", "img/worker.jpg"));
        customerMap.put(4, new Customer("Name", "12/09/2003", "Da Nang", "img/worker.jpg"));
        customerMap.put(5, new Customer("Name", "12/09/2003", "Da Nang", "img/worker.jpg"));
    }

    public List<Customer> getList() {
        return new ArrayList<>(customerMap.values());
    }

}
