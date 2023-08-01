package repository.interf;

import model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> findAll();

    Book findByID(String id);
}
