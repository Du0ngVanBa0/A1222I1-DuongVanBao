package service.Interf;

import model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findById(int id);
}
