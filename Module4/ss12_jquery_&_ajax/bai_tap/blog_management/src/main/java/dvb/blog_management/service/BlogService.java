package dvb.blog_management.service;

import dvb.blog_management.entity.Blog;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BlogService {

    Iterable<Blog> findAll();

    Iterable<Blog> findByHead(String name);

    Iterable<Blog> findAllPaging(Pageable pageable);
}
