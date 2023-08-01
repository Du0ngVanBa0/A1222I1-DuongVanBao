package service.user;

import model.User;
import repository.user.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
