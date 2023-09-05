package dvb.book_rent.service;

import dvb.book_rent.entity.Book;
import dvb.book_rent.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByID(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void rent(Book book) {
        bookRepository.save(book);
    }
}
