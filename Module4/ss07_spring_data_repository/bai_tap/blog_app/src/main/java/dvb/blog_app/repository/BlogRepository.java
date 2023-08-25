package dvb.blog_app.repository;

import dvb.blog_app.entity.Blog;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByHeadContaining(String inp);

    @Query(value = "select * from blog  where category_id = :cateID", nativeQuery = true)
    List<Blog> findAllBlogByCategoryID(@Param("cateID") int cateID);
}
