package service.Impl;

import model.Role;
import repository.Impl.UserRoleRepo;
import service.Interf.IUserRoleService;

import java.util.List;

public class UserRoleService implements IUserRoleService {
    UserRoleRepo userRoleRepo = new UserRoleRepo();

    @Override
    public List<Role> findAllRoleByUserID(String user_id) {
        return userRoleRepo.findAllRoleByUserID(user_id);
    }
}
