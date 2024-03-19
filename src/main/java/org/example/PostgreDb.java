package org.example;

import java.util.List;

public class PostgreDb extends DatabaseServiceImpl{

    public PostgreDb(List<User> users, List<Book> books, List<Borrow> borrows, List<Attendant> attendants) {
        super(users, books, borrows, attendants);
    }


}
