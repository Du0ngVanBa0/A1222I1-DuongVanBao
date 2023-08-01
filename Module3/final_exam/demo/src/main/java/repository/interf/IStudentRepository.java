package repository.interf;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    Student findByID(int id);
}
