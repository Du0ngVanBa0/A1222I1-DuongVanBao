package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findAllByNameContaining(String name);
    List<Book> findAllByNameContainingOrAuthorContaining(String name, String author);

//    @Query("From Book b where b.author like :author")
    @Query(name = "select * from Book where author like :author", nativeQuery = true)
    List<Book> findByAuthor(@Param("author") String author);
}
