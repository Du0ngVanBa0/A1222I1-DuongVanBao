package dvb.blog_management.service;

import dvb.blog_management.entity.Blog;
import dvb.blog_management.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findByCategoryId(int id) {
        return blogRepository.findAllBlogByCategoryId(id);
    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }
}
