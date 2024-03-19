package org.example;

import java.time.LocalDateTime;

public class Borrow {
    private int id;
    private User user;
    private Book book;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    private boolean isLate;
    private boolean isReturned;



    public Borrow(int id, User user, Book book, LocalDateTime borrowDate, LocalDateTime returnDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = false;
        this.isLate = false;
    }



    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public boolean isLate() {
        return isLate;
    }

    public void setLate(boolean late) {
        isLate = late;
    }


}
