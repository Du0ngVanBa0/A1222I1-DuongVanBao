package codegym.vn.springsecurity.service;

import codegym.vn.springsecurity.entity.AccountRole;

import java.util.List;

public interface AccountRoleService {
    void create(AccountRole accountRole);
    void deleteAccountRoleById(Long id);
    List<String> findRoleByUsername(String username);
}
