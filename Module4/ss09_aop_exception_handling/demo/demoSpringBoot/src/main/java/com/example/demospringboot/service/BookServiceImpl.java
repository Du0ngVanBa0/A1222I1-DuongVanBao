package com.example.demospringboot.service;

import com.example.demospringboot.entity.Book;
import com.example.demospringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository repository;
    @Override
    public void create(Book book) {
        repository.save(book);
    }

    @Override
    public void update(Book book) {
        repository.save(book);
    }

    @Override
    public Book findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Slice<Book> findAllSlice(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
