package repository.Impl;

import model.Role;
import repository.Interf.IRoleRepo;
import util.Constraints;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepo implements IRoleRepo {
    @Override
    public List<Role> findAll() {
        List<Role>roles=new ArrayList<>();
        try (Connection connection= DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_ROLE);){
            ResultSet resultSet=statement.executeQuery();
            Role role;
            while (resultSet.next())
            {
                int id=resultSet.getInt("role_id");
                String name=resultSet.getString("role_name");
                role=new Role(id,name);
                roles.add(role);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }

    @Override
    public Role findById(int id) {
        Role role=null;
        try (Connection connection= DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ROLE_BY_ID);){
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                String name=resultSet.getString("role_name");
                role=new Role(id,name);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return role;
    }
}
