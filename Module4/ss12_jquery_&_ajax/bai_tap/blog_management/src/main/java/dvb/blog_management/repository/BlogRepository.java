package dvb.blog_management.repository;

import dvb.blog_management.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where category_id = :cateId", nativeQuery = true)
    Iterable<Blog> findAllBlogByCategoryId(@Param("cateId") int cateId);

    Iterable<Blog> findAllByHeadContains(String head);
}
