package dvb.blog_app.service;

import dvb.blog_app.entity.Blog;
import dvb.blog_app.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void create(Blog blog) {
        blog.setReleasedDate(new Date());
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllSort() {
        return blogRepository.findAll(Sort.by(Sort.Direction.ASC, "releasedDate"));
    }

    @Override
    public List<Blog> findByHead(String inp) {
        return blogRepository.findByHeadContaining(inp);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }
}
