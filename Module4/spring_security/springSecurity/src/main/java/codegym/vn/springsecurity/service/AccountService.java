package codegym.vn.springsecurity.service;

import codegym.vn.springsecurity.entity.Account;

import java.util.List;

public interface AccountService {
    void create(Account account);
    Account findAccountByUsername(String username);
    void deleteById(Long id);
    List<Account> findAll();
}
