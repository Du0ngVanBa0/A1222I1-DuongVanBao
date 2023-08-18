package dvb.repository;

import dvb.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentRepository implements ICommentRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public List<Comment> findAll() {
        return entityManager.createQuery("from Comment c").getResultList();
    }

    @Override
    public void updateLike(int id) {
        Comment comment = entityManager.find(Comment.class, id);
        comment.setLikes(comment.getLikes() + 1);
        entityManager.merge(comment);
    }
}
