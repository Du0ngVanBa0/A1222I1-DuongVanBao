package dvb.repository;

import dvb.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static Map<String, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put("SV001", new Student("SV001", "Toàn", 22, "Đà Nẵng"));
        studentMap.put("SV002", new Student("SV002", "Anh", 21, "Đà Nẵng"));
        studentMap.put("SV003", new Student("SV003", "Em", 2, "Đà Nẵng"));
        studentMap.put("SV004", new Student("SV004", "Cha", 34, "Đà Nẵng"));
        studentMap.put("SV005", new Student("SV005", "Cu", 12, "Đà Nẵng"));
    }

    @Override
    public void createOrUpdate(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public Student findById(String id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void deleteById(String id) {
        studentMap.remove(id);
    }
}
