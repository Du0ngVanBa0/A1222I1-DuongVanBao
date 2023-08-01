package service.interf;

import model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findByID(String id);
}
