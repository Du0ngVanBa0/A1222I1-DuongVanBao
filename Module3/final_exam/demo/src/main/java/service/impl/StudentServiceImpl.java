package service.impl;

import model.Student;
import repository.impl.StudentRepositoryImpl;
import service.interf.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByID(int id) {
        return studentRepository.findByID(id);
    }
}
