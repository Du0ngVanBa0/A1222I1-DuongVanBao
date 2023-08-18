package dvb.repository;

import dvb.entity.Comment;

import java.util.List;

public interface ICommentRepository {
    void save(Comment comment);

    List<Comment> findAll();

    void updateLike(int id);
}
