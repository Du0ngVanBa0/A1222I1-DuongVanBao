package dvb.blog_app.repository;

import dvb.blog_app.entity.Blog;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByHeadContaining(String inp);
}
