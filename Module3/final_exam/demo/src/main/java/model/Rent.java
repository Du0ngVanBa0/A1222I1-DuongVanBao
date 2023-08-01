package model;

import java.util.Date;

public class Rent {
    private int id;
    private Book book;
    private Student student;
    private boolean status;
    private Date rent_date;
    private Date back_date;

    public Rent(int id, Book book, Student student, boolean status, Date rent_date, Date back_date) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.status = status;
        this.rent_date = rent_date;
        this.back_date = back_date;
    }

    public Rent(Book book, Student student, boolean status, Date rent_date, Date back_date) {
        this.book = book;
        this.student = student;
        this.status = status;
        this.rent_date = rent_date;
        this.back_date = back_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getRent_date() {
        return rent_date;
    }

    public void setRent_date(Date rent_date) {
        this.rent_date = rent_date;
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }
}
