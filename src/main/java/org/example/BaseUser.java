package org.example;

public abstract class BaseUser {
    private int id;
    protected String mail;
    protected String password;




    public BaseUser(int id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }



}
