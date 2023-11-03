package codegym.vn.springsecurity.entity;

import javax.persistence.*;

@Entity
public class AccountRole {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private Role role;

    public AccountRole() {
    }

    public AccountRole(Account account, Role role) {
        this.account = account;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
