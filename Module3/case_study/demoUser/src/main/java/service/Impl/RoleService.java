package service.Impl;

import model.Role;
import repository.Impl.RoleRepo;
import service.Interf.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    RoleRepo roleRepo=new RoleRepo();
    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepo.findById(id);
    }
}
