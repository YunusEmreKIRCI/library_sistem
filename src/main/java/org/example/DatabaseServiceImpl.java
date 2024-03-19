package org.example;

import java.time.LocalDateTime;
import java.util.List;

public abstract class DatabaseServiceImpl implements DatabaseService{
    private List<User> users;
    private List<Book> books;
    private List<Borrow> borrows;
    private List<Attendant> attendants;

    private int bookId = 0;
    private int userId = 0;
    private int borrowId = 0;

public DatabaseServiceImpl(List<User> users, List<Book> books, List<Borrow> borrows, List<Attendant> attendants) {
        this.users = users;
        this.books = books;
        this.borrows = borrows;
        this.attendants = attendants;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public List<Attendant> getAttendants() {
        return attendants;
    }

    public Book getBookByID(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public User getUserByID(int id) {
        for (User user : users) {
            if (user.getId() == id) {
               return user;
            }
        }
        return null;
    }

    public Borrow getBorrowByID(int id) {
        for (Borrow borrow : borrows) {
            if (borrow.getId() == id) {
               return borrow;
            }
        }
        return null;
    }

    public Attendant getAttendantByID(int id) {
        for (Attendant attendant : attendants) {
            if (attendant.getId() == id) {
               return attendant;
            }
        }
        return null;
    }

    public List<Book> getBooksByNames(String name) {
        List<Book> bookList = null;
        for (Book book : books) {
            if (book.getName().equals(name)) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public User getUsersByMail(String mail) {

        for (User user : users) {
            if (user.getMail().equals(mail)) {
                return user;
            }
        }
        return null;
    }

    public Attendant getAttendantByMail(String mail) {

        for (Attendant attendant : attendants) {
            if (attendant.getMail().equals(mail)) {
                return attendant;
            }
        }
        return null;
    }

    public void updateBookAvailability(int id, boolean availability) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setAvailability(availability);
            }
        }
    }


    public void addUser(String mail, String password) {
        for (User user : users) {
            if (user.getMail().equals(mail)) {
                System.out.println("User already exists");
                return;
            }
        }
        users.add(new User(userId, mail, password));
        this.userId++;
    }

    public void addBook(String name, boolean availability) {

        books.add(new Book(bookId, name, availability));
        this.bookId++;
    }

    public void addAttendant(String mail, String password) {
        for (Attendant attendant : attendants) {
            if (attendant.getMail().equals(mail)) {
                System.out.println("Attendant already exists");
                return;
            }
        }
        attendants.add(new Attendant(userId, mail, password));
        this.userId++;
    }

    public void borrowBook(User user, Book book, LocalDateTime borrowDate, LocalDateTime returnDate) {

        borrows.add(new Borrow(bookId,user, book, borrowDate, returnDate));
        this.bookId++;
    }
    public void updateBorrowLate(int id, boolean isLate) {
        for (Borrow borrow : borrows) {
            if (borrow.getId() == id) {
                borrow.setLate(isLate);
            }
        }
    }
    public Borrow getBorrowByAttributes(User user, Book book, LocalDateTime borrowDate, LocalDateTime returnDate) {
        for (Borrow borrow : borrows) {
            if (borrow.getUser().equals(user) && borrow.getBook().equals(book) && borrow.getBorrowDate().equals(borrowDate) && borrow.getReturnDate().equals(returnDate)) {
                return borrow;
            }
        }
        return null;
    }
}
