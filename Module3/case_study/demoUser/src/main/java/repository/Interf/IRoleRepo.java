package repository.Interf;

import model.Role;

import java.util.List;

public interface IRoleRepo {
    List<Role> findAll();
    Role findById(int id);
}
