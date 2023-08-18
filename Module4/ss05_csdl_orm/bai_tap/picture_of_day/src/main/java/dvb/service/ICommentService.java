package dvb.service;

import dvb.entity.Comment;

import java.util.List;

public interface ICommentService {
    void save(Comment comment);

    List<Comment> findAll();

    void updateLike(int id);
}
