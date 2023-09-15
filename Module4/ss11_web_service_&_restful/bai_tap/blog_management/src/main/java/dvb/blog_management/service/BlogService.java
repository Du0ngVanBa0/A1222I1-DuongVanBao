package dvb.blog_management.service;

import dvb.blog_management.entity.Blog;

import java.util.Optional;

public interface BlogService {
    Iterable<Blog> findByCategoryId(int id);

    Iterable<Blog> findAll();

    Optional<Blog> findById(int id);
}
