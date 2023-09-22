package com.example.demospringboot.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Book {
    @Id
    @Column(columnDefinition = "varchar(10)")
//    @Pattern(regexp = "B[d]{4}", message = "BookId phải có dạng Bxxxx")
//    @Pattern(regexp = "B[d]{4}", message = "{Book.bookID}")
//    @Size(min = 5, max = 5, message = "{Book.bookID.length}")
    private String bookId;

    @NotBlank(message = "{Book.name.empty}")
    private String name;
    @Size(min = 3, max = 60, message = "{Book.author.size}")
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publish;
    @Min(0)
    private long price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book() {
    }

    public Book(String bookId, String name, String author, Date publish, long price, Category category) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.price = price;
        this.category = category;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublish() {
        return publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
