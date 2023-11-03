package codegym.vn.springsecurity.service;

import codegym.vn.springsecurity.entity.Role;
import codegym.vn.springsecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository repository;
    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }
}
