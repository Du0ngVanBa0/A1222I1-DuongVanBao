package com.example.demodatajpa.service;

import com.example.demodatajpa.entity.Book;

import java.util.List;

public interface BookService {
    void create(Book book);
    void update(Book book);
    Book findById(String id);
    List<Book> findAll();
    void deleteById(String id);
}
