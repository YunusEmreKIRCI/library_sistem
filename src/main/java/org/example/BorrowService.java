package org.example;

import java.time.LocalDateTime;

public class BorrowService {
    private DatabaseService databaseService;
    private Logger logger;

    public BorrowService(DatabaseService databaseService, Logger logger) {
        this.databaseService = databaseService;
        this.logger = logger;
    }

    public void borrowBook(int userID, int bookID, LocalDateTime borrowDate, LocalDateTime returnDate) {
        Book book = databaseService.getBookByID(bookID);
        User user = databaseService.getUserByID(userID);
        if (book.getAvailability()) {
            databaseService.borrowBook(user, book, borrowDate, returnDate);
            databaseService.updateBookAvailability(bookID, false);
        }
        logger.log("Book is not available: " + book.getName() + " for user: " + user.getMail() + " at " + LocalDateTime.now());

    }

    public void returnBook(int userID, int bookID, LocalDateTime returnDate, LocalDateTime BorrowDate, LocalDateTime now) {
        Book book = databaseService.getBookByID(bookID);
        User user = databaseService.getUserByID(userID);
        Borrow borrow = databaseService.getBorrowByAttributes(user, book, BorrowDate, returnDate);
        if (now.isAfter(borrow.getReturnDate().plusDays(5))) {
            databaseService.updateBorrowLate(borrow.getId(), true);

            logger.log("Book is returned late: " + book.getName() + " for user: " + user.getMail() + " at " + LocalDateTime.now());

        }

        databaseService.updateBookAvailability(bookID, true);
        logger.log("Book is returned: " + book.getName() + " for user: " + user.getMail() + " at " + LocalDateTime.now());


    }





}
