package model;

import java.util.Date;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String code;
    private Date birthday;
    private Date dateRelease;

    private List<Role> roleList;

    public User(String id, String name, String code, Date birthday, Date dateRelease, List<Role> roleList) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.birthday = birthday;
        this.dateRelease = dateRelease;
        this.roleList = roleList;
    }

    public boolean hasRole(int role_id) {
        for (Role role : roleList) {
            if (role.getId() == role_id) {
                return true;
            }
        }
        return false;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }
}
