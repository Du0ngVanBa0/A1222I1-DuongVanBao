package dvb.repository;

import dvb.bean.Student;

import java.util.List;

public interface StudentRepository {
    void createOrUpdate(Student student);

    Student findById(String id);

    List<Student> findAll();

    void deleteById(String id);
}
