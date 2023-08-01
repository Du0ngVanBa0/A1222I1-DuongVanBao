package repository.Interf;

import model.Role;

import java.util.List;

public interface IUserRoleRepo {
    List<Role> findAllRoleByUserID(String user_id);
}
