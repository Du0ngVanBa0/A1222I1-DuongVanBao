package repository.Impl;

import model.Role;
import repository.Interf.IUserRoleRepo;
import util.Constraints;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleRepo implements IUserRoleRepo {
    @Override
    public List<Role> findAllRoleByUserID(String user_id) {
        List<Role> roleList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.FIND_ROLE_BY_USER_ID);
        ) {
            statement.setString(1, user_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                roleList.add(new Role(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return roleList;
    }
}
