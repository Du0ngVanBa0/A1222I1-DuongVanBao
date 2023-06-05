package final_exam.repository.Interfaces;

import java.util.List;

public interface IPhone<T> {
    List<T> getList();

    void addNew(T obj);

    void delete(List<T> obj);
}
