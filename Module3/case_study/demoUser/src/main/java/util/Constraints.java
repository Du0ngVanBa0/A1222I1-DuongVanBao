package util;

public class Constraints {
    public static final String CREATE_USER = "insert into userr values(?,?,?,?,?)";
    public static final String CREATE_USER_ROLE = "insert into user_role values(?,?)";
    public static final String FIND_ALL_USER = "select * from userr limit ? offset ?";
    public static final String SEARCH_USER = "select * from userr where user_name like ? limit ? offset ?";
    public static final String COUNT_ALL_USER = "select count(1) from userr";
    public static final String COUNT_ALL_USER_BY_NAME = "select count(1) from userr where user_name like ?";
    public static final String FIND_USER_BY_ID = "select * from userr where user_id=?";
    public static final String DELETE_USER_BY_ID = "delete from userr where user_id=?;";
    public static final String DELETE_USER_ROLE_BY_ID = "delete from user_role where user_id = ?;";
    public static final String UPDATE_USER = "update userr set user_name=?,user_code=?,user_birthday=?,user_daterelease=? where user_id=?";
    public static final String FIND_ALL_ROLE = "select * from rolee";
    public static final String FIND_ROLE_BY_ID = "select * from rolee where role_id=?";

    public static final String FIND_ROLE_BY_USER_ID = "Select * from rolee where role_id in (select role_id  from user_role where user_id = ?);";
}
