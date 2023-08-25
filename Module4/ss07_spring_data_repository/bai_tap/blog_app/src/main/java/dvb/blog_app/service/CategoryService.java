package dvb.blog_app.service;

import dvb.blog_app.entity.Category;

import java.util.List;

public interface CategoryService {
    void create(Category category);

    List<Category> findAll();

    Category findByID(int id);

    void deleteByID(int id);

    void update(Category category);
}
