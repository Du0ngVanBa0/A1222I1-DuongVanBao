package dvb.furama.entity;

import dvb.furama.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_name",referencedColumnName = "userName")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "roleId")
    private Role role;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
