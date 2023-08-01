package repository.impl;

import model.Student;
import repository.interf.IStudentRepository;
import util.Constraints;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private List<Student> studentList;

    @Override
    public List<Student> findAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.FIND_ALL_STUDENT);
        ) {
            ResultSet rs = statement.executeQuery();
            studentList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String s_class = rs.getString(3);
                studentList.add(new Student(id, name, s_class));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public Student findByID(int student_id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.FIND_STUDENT_BY_ID);
        ) {
            statement.setInt(1, student_id);
            ResultSet rs = statement.executeQuery();
            studentList = new ArrayList<>();
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String s_class = rs.getString(3);
                return new Student(id, name, s_class);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
