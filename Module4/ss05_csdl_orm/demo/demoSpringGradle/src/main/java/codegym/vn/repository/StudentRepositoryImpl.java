package codegym.vn.repository;

import codegym.vn.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void delete(Student student) {
        entityManager.remove(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student findById(String id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student s").getResultList();
    }

    public List<Student> findAllByName(String name) {
        return entityManager
                .createQuery("select s from Student s where s.name like :name")
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
