package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Book;
import com.example.demospringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookRestController {
    @Autowired
    private BookService bookService;
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(bookService.searchByName(name), HttpStatus.OK);
    }
}
