package dvb.blog_management.service;

import dvb.blog_management.entity.Blog;
import dvb.blog_management.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Iterable<Blog> findByHead(String name) {
        return blogRepository.findAllByHeadContains(name);
    }

    @Override
    public Iterable<Blog> findAllPaging(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
