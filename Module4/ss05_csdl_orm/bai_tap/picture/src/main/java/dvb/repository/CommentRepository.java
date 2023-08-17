package dvb.repository;

import dvb.entity.Comment;

import java.util.List;

public interface CommentRepository {
    void save(Comment comment);

    List<Comment> findAll();
}
