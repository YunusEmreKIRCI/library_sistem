package org.example;

import java.time.LocalDateTime;
import java.util.List;

public interface DatabaseService {

    public Book getBookByID(int id);

    public User getUserByID(int id);

    public Borrow getBorrowByID(int id);

    public Attendant getAttendantByID(int id);

    public List<Book> getBooksByNames(String name);

    public User getUsersByMail(String mail);

    public Attendant getAttendantByMail(String mail);

    public void updateBookAvailability(int id, boolean availability);


    public void addUser(String mail, String password);

    public void addBook(String name, boolean availability);

    public void addAttendant(String mail, String password);

    public void borrowBook(User user, Book book, LocalDateTime borrowDate, LocalDateTime returnDate);

    public Borrow getBorrowByAttributes(User user, Book book, LocalDateTime borrowDate, LocalDateTime returnDate);

    public void updateBorrowLate(int id, boolean isLate);

}
