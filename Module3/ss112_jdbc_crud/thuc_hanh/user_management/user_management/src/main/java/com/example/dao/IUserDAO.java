package com.example.dao;

import com.example.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();
    public List<User> selectAllUsersStore();

    public List<User> selectUserByCountry(String inp);

    public void deleteUser(int id) throws SQLException;
    public void deleteUserStore(int id);

    public void updateUser(User user) throws SQLException;
    public void updateUserStore(User user);

    public User getUserById(int id);

    public void insertUserStore(User user);

    public void addUserTransaction(User user, int[] permission);

    public void insertUpdateWithoutTransaction();
    public void insertUpdateUseTransaction();
}
