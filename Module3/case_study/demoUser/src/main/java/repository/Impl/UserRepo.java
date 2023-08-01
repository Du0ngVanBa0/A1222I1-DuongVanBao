package repository.Impl;

import model.Role;
import model.User;
import repository.Interf.IUserRepo;
import service.Impl.RoleService;
import util.Constraints;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRepo implements IUserRepo {
    private RoleService roleService = new RoleService();
    private UserRoleRepo userRoleRepo = new UserRoleRepo();

    @Override
    public List<User> findAll(int page, int record) {
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.FIND_ALL_USER);) {
            statement.setInt(1, record);
            statement.setInt(2, (page - 1) * record);
            ResultSet resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()) {
                String id = resultSet.getString("user_id");
                String name = resultSet.getString("user_name");
                String code = resultSet.getString("user_code");
                Date birthday = new Date(resultSet.getDate("user_birthday").getTime());
                Date dateRelease = new Date(resultSet.getDate("user_daterelease").getTime());
                List<Role> roleList = userRoleRepo.findAllRoleByUserID(id);
                user = new User(id, name, code, birthday, dateRelease, roleList);
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void delete(String id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.DELETE_USER_BY_ID);
             PreparedStatement statement1 = connection.prepareStatement(Constraints.DELETE_USER_ROLE_BY_ID)) {
            statement.setString(1, id);
            statement1.setString(1, id);
            statement1.executeUpdate();
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.UPDATE_USER);
             PreparedStatement insert_user_role = connection.prepareStatement(Constraints.CREATE_USER_ROLE);
             PreparedStatement delete_user_role = connection.prepareStatement(Constraints.DELETE_USER_ROLE_BY_ID);) {
            statement.setString(5, user.getId());
            statement.setString(1, user.getName());
            statement.setString(2, user.getCode());
            statement.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
            statement.setDate(4, new java.sql.Date(user.getDateRelease().getTime()));
            delete_user_role.setString(1, user.getId());
            delete_user_role.executeUpdate();
            statement.executeUpdate();
            for (Role role : user.getRoleList()) {
                insert_user_role.setString(1, user.getId());
                insert_user_role.setInt(2, role.getId());
                insert_user_role.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(String id) {
        User user = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.FIND_USER_BY_ID);) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("user_name");
                String code = resultSet.getString("user_code");
                Date birthday = new Date(resultSet.getDate("user_birthday").getTime());
                Date dateRelease = new Date(resultSet.getDate("user_daterelease").getTime());
                List<Role> roleList = userRoleRepo.findAllRoleByUserID(id);
                user = new User(id, name, code, birthday, dateRelease, roleList);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void add(User user) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.CREATE_USER);
             PreparedStatement statement1 = connection.prepareStatement(Constraints.CREATE_USER_ROLE);) {
            statement.setString(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getCode());
            statement.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
            statement.setDate(5, new java.sql.Date(user.getDateRelease().getTime()));
            statement.executeUpdate();
            statement1.setString(1, user.getId());
            for (Role role : user.getRoleList()) {
                statement1.setInt(2, role.getId());
                statement1.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.COUNT_ALL_USER);
        ) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public List<User> search(String inp_name, int page, int record) {
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.SEARCH_USER);) {
            statement.setString(1, "%" + inp_name + "%");
            statement.setInt(2, record);
            statement.setInt(3, (page - 1) * record);
            ResultSet resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()) {
                String id = resultSet.getString("user_id");
                String user_name = resultSet.getString("user_name");
                String code = resultSet.getString("user_code");
                Date birthday = new Date(resultSet.getDate("user_birthday").getTime());
                Date dateRelease = new Date(resultSet.getDate("user_daterelease").getTime());
                List<Role> roleList = userRoleRepo.findAllRoleByUserID(id);
                user = new User(id, user_name, code, birthday, dateRelease, roleList);
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public int countSearch(String name) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.COUNT_ALL_USER_BY_NAME);
        ) {
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
