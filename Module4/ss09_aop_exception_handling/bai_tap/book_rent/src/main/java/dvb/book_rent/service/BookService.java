package dvb.book_rent.service;

import dvb.book_rent.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();

    public Book findByID(int id);

    public void rent(Book book);
}
