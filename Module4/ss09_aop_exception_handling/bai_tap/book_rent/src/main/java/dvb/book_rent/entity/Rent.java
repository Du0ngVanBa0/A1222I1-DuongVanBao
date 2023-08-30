package dvb.book_rent.entity;

import javax.persistence.*;

@Entity
public class Rent {
    @Id
    @Column(columnDefinition = "varchar(5)")
    private String id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rent() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Rent(String id, Book book) {
        this.id = id;
        this.book = book;
    }
}
