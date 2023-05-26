package case_study.FuramaResort.repository.interfaces;

import java.util.List;

public interface IRepository<T> {
    List<T> getList();

    void addNew(T obj);
}
