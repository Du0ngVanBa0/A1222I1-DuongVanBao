package service.interf;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findByID(int id);
}
