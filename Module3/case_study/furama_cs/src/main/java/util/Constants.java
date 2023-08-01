package util;

public class Constants {
    public static final String CREATE_CUSTOMER = "insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) values(?,?,?,?,?,?,?,?);";
    public static final String CREATE_EMPLOYEE = "insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username) values(?,?,?,?,?,?,?,?,?,?,?);";
    public static final String FIND_ALL_CUSTOMER_TYPE = "select * from customer_type";
    public static final String FIND_ALL_CUSTOMER = "select * from customer";
    public static final String FIND_ALL_EMPLOYEE = "select * from employee";
    public static final String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id = ?";
    public static final String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id = ?";
    public static final String FIND_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";

    public static final String FIND_EMPLOYEE_BY_NAME = "select * from employee where employee_name like ?";

    public static final String FIND_EMPLOYEE_BY_NAME_OR_ID = "select * from employee where employee_name like ? or employee_id = ?";
    public static final String FIND_DIVISION_BY_ID = "select * from division where division_id = ?";
    public static final String FIND_POSITION_BY_ID = "select * from position where position_id = ?";
    public static final String FIND_EDUCATION_DEGREE_BY_ID = "select * from education_degree where education_degree_id = ?";
    public static final String FIND_USER_BY_USERNAME = "select * from user where username = ?";
    public static final String EDIT_CUSTOMER_BY_ID = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?";
    public static final String FIND_CUSTOMER_TYPE_BY_ID = "select * from customer_type where customer_type_id = ?;";
    public static final String FIND_ALL_CUSTOMER_PAGING = "select * from customer limit ? offset ?";
    public static final String FIND_ALL_USER = "select * from user";
    public static final String FIND_ALL_POSITION = "select * from position";
    public static final String FIND_ALL_EDUCATION_DEGREE = "select * from education_degree";
    public static final String FIND_ALL_DIVISION = "select * from division";
    public static final String COUNT_ALL_CUSTOMER = "select count(1) from customer";
    public static final String FIND_CUSTOMER_BY_NAME = "select * from customer where customer_name like ? limit ? offset ?";
}
