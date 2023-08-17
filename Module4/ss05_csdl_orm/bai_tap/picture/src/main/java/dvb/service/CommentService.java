package dvb.service;

import dvb.entity.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    List<Comment> findAll();
}
