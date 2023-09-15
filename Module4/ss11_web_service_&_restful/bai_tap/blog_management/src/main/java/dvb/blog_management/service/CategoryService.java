package dvb.blog_management.service;

import dvb.blog_management.entity.Category;

public interface CategoryService {
    Iterable<Category> findAll();
}
