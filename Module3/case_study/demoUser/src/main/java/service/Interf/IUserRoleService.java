package service.Interf;

import model.Role;

import java.util.List;

public interface IUserRoleService {
    List<Role> findAllRoleByUserID(String user_id);
}
