package com.example.demospringboot.service;

import com.example.demospringboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface BookService {
    void create(Book book);
    void update(Book book);
    Book findById(String id);
    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    Slice<Book> findAllSlice(Pageable pageable);
    void deleteById(String id);
}
