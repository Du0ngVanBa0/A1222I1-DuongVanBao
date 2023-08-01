package service.impl;

import model.Book;
import repository.impl.BookRepositoryImpl;
import service.interf.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByID(String id) {
        return bookRepository.findByID(id);
    }
}
