package com.library.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent")
public class Rent extends AbstractEntityId {

    @ManyToOne(fetch = FetchType.LAZY)
    private BookCopy copyOfBook;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client user;

    @Column(name = "borrowing_time")
    private LocalDateTime borrowingTime;

    @Column(name = "return_time", length = 20)
    private LocalDateTime returnTime;

    public LocalDateTime getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowingTime(LocalDateTime borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    public Client getUser() {
        return user;
    }

    public void setUser(Client user) {
        this.user = user;
    }

    public BookCopy getCopyOfBook() {
        return copyOfBook;
    }

    public void setCopyOfBook(BookCopy copyOfBook) {
        this.copyOfBook = copyOfBook;
    }


}
