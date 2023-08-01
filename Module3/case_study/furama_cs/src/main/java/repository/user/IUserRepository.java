package repository.user;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    User findByUsername(String username);
}
