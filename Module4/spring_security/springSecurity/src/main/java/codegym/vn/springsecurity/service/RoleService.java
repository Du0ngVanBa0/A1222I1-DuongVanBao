package codegym.vn.springsecurity.service;

import codegym.vn.springsecurity.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
}
