package service.Impl;

import model.User;
import repository.Impl.UserRepo;
import service.Interf.IUserService;

import java.util.List;

public class UserService implements IUserService {
    UserRepo userRepon = new UserRepo();

    @Override
    public List<User> findAll(int page, int record) {
        return userRepon.findAll(page, record);
    }

    @Override
    public void delete(String id) {
        userRepon.delete(id);
    }

    @Override
    public void update(User user) {
        userRepon.update(user);
    }

    @Override
    public User findById(String id) {
        return userRepon.findById(id);
    }

    @Override
    public void add(User user) {
        userRepon.add(user);
    }

    @Override
    public int countAll() {
        return userRepon.countAll();
    }

    @Override
    public List<User> search(String name, int page, int record) {
        return userRepon.search(name, page, record);
    }

    @Override
    public int countAllSearch(String name) {
        return userRepon.countSearch(name);
    }
}
