package codegym.vn.springsecurity.service;

import codegym.vn.springsecurity.entity.AccountRole;
import codegym.vn.springsecurity.repository.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRoleServiceImpl implements  AccountRoleService{
    @Autowired
    private AccountRoleRepository repository;
    @Override
    public void create(AccountRole accountRole) {
        repository.save(accountRole);
    }

    @Override
    public void deleteAccountRoleById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<String> findRoleByUsername(String username) {
        return repository.findAllRoleNameByUsername(username);
    }
}
