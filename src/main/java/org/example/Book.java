package org.example;

public class Book {
    private int id;
    private String name;
    private boolean availability;

    public Book(int id, String name, boolean availability) {
        this.id = id;
        this.name = name;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
