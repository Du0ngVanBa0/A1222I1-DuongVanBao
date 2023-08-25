package com.example.demospringboot.utils;

import com.example.demospringboot.entity.Book;
import com.example.demospringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {
    @Autowired
    private BookService bookService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Book)) {
            return;
        }

        Book book = (Book) target;
        String bookId = book.getBookId();
        if (bookId.length() != 4) {
            errors.rejectValue("bookId", "Book.bookID.length",
                    new String[]{"4"}, "Book ID phải có 5 ký tự");
        } else if (!bookId.matches("B[0-9]{3}")) {
            errors.rejectValue("bookId", "Book.bookID",
                    null, "Book ID phải đúng định dạng");
        } else if (bookService.findById(bookId) != null) {
            errors.rejectValue("bookId", "Book.exist",
                    null, "Book ID đã tồn tại");
        }
    }
}
