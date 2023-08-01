package repository.impl;

import model.Book;
import model.Rent;
import model.Student;
import repository.interf.IRentRepository;
import service.impl.BookServiceImpl;
import service.impl.StudentServiceImpl;
import util.Constraints;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentRepositoryImpl implements IRentRepository {
    BookServiceImpl bookService = new BookServiceImpl();
    List<Rent> rents;
    StudentServiceImpl studentService = new StudentServiceImpl();

    @Override
    public void add(Rent rent) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.ADD_RENT);
        ){
            statement.setString(1,rent.getBook().getId());
            statement.setInt(2,rent.getStudent().getId());
            statement.setBoolean(3,rent.isStatus());
            statement.setDate(4,new Date(rent.getRent_date().getTime()));
            statement.setDate(5,new Date(rent.getBack_date().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Rent> findAll() {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constraints.FIND_ALL_RENT);
        ) {
            ResultSet rs = statement.executeQuery();
            rents = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt(1);
                Book book = bookService.findByID(rs.getString(2));
                Student student = studentService.findByID(rs.getInt(3));
                boolean status = rs.getBoolean(4);
                java.util.Date rent_date = rs.getDate(5);
                java.util.Date back_date = rs.getDate(6);
                rents.add(new Rent(id,book,student,status,rent_date,back_date));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rents;
    }
}
