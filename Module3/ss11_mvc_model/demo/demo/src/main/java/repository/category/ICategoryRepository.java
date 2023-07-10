package repository.category;

import model.Category;

import java.util.List;

public interface ICategoryRepository {
    void add(Category category);
    void update(Category category);
    Category findByID(int id);
    List<Category> findAll();
    void delete(Category category);
}
