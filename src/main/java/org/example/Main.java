package org.example;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Sistem oluşturuldu
        DatabaseService postgres = new PostgreDb(new ArrayList<User>(), new ArrayList<Book>(), new ArrayList<Borrow>(), new ArrayList<Attendant>());
        Logger logger = new FileLogger();
        AuthService authService = new AuthService(postgres, logger);
        BorrowService borrowService = new BorrowService(postgres, logger);
        LocalDateTime now = LocalDateTime.now();
        //kullanıcı kaydı
        postgres.addUser("Emre@gmail.com", "1234");
        postgres.addUser("Harun@gmail.com", "1234");
        postgres.addUser("Berkan@gmail.com", "1234");
        //görevli kaydı
        postgres.addAttendant("Burak@gmail.com", "1234");
        //kitap kaydı
        postgres.addBook("Harry Potter", true);
        postgres.addBook("Lord of the Rings", true);
        postgres.addBook("Game of Thrones", true);
        postgres.addBook("The Witcher", true);
        postgres.addBook("The Hobbit", true);
        postgres.addBook("The Alchemist", true);
        postgres.addBook("The Catcher in the Rye", true);
        postgres.addBook("The Great Gatsby", true);
        //login işlemleri
        authService.userLogin("Emre@gmail.com", "1234");
        authService.attendantLogin("Burak@gmail.com", "1234");
        //kitap ödünç alma işlemleri
        borrowService.borrowBook(1, 1, now, now.plusDays(15));
        borrowService.borrowBook(2, 2, now, now.plusDays(15));
        borrowService.borrowBook(0, 0, now, now.plusDays(15));
        borrowService.returnBook(1, 1, now.plusDays(15), now, now.plusDays(12));
        borrowService.returnBook(2, 2, now.plusDays(15), now, now.plusDays(16));
        borrowService.returnBook(0, 0, now.plusDays(15), now, now.plusDays(22));
        authService.userLogout();
        authService.attendantLogout();
    }
}