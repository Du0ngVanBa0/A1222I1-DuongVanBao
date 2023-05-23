package case_study.FuramaResort.repository.interfaces;

import java.util.List;

public interface IEmployeeRepository<T> extends IRepository<T> {
    void edit(List<T> newList);
}
