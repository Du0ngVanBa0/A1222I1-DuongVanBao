package dvb.furama.entity.user;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(columnDefinition = "varchar(50)")
    private String userName;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
