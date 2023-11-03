package codegym.vn.springsecurity.repository;

import codegym.vn.springsecurity.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
    @Query("select ar.role.roleName from AccountRole ar where ar.account.username = :username")
    List<String> findAllRoleNameByUsername(@Param("username") String username);
}
