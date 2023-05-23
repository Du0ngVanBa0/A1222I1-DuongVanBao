package case_study.FuramaResort.repository.interfaces;

import java.util.List;

public interface ICustomerRepository<T> extends IRepository<T> {
    void edit(List<T> newList);
}
