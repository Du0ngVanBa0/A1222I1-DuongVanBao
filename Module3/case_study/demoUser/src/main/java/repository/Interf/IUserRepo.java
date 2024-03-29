package repository.Interf;

import model.User;

import java.util.List;

public interface IUserRepo {
    List<User> findAll(int page, int record);

    void delete(String id);

    void update(User user);

    User findById(String id);

    void add(User user);

    int countAll();

    List<User> search(String name, int page, int record);

    int countSearch(String name);
}
