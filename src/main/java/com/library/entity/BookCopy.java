package com.library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "copy_of_book")
public class BookCopy extends AbstractEntityId {

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @OneToMany(mappedBy = "copyOfBook")
    private List<Rent> rents;

    @Column(name = "is_available")
    private Boolean isAvailable;

    private BookState state;

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public BookState getState() {
        return state;
    }

    public void setState(BookState state) {
        this.state = state;
    }
}
