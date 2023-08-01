package util;

public class Constraints {
    public static String FIND_ALL_BOOK = "Select * from book";
    public static String FIND_ALL_STUDENT = "Select * from student";
    public static String FIND_ALL_RENT = "Select * from rent where rent_status = 1";
    public static String FIND_STUDENT_BY_ID = "Select * from student where id = ?";
    public static String FIND_BOOK_BY_ID = "Select * from book where id = ?";
    public static String ADD_RENT = "insert into rent(book_id,student_id,rent_status,rent_date,back_date) values (?,?,?,?,?)";

}
