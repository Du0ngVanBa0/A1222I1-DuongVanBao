package service.category;

import model.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(int id);

    List<Category> findAll();

    void add(Category category);

    void delete(Category category);

    void update(Category category);
}
