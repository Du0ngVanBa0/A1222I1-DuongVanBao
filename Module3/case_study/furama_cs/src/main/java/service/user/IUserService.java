package service.user;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findByUsername(String username);
}
