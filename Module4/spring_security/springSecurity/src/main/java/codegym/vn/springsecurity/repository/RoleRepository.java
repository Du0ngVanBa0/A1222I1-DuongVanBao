package codegym.vn.springsecurity.repository;

import codegym.vn.springsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
