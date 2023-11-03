package codegym.vn.springsecurity.repository;

import codegym.vn.springsecurity.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
