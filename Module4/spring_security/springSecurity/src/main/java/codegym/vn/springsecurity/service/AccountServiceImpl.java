package codegym.vn.springsecurity.service;

import codegym.vn.springsecurity.entity.Account;
import codegym.vn.springsecurity.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository repository;
    @Override
    public void create(Account account) {
        repository.save(account);
    }

    @Override
    public Account findAccountByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }
}
