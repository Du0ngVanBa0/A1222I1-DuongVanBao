package model;

public class UserRole {
    private Role role;
    private User user;

    public UserRole(Role role, User user) {
        this.role = role;
        this.user = user;
    }

    public UserRole() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
