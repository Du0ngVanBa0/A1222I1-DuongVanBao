package dvb.blog_app.service;

import dvb.blog_app.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    void create(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAllSort();

    List<Blog> findByHead(String inp);

    void deleteById(int id);
}
