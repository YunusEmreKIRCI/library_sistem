package org.example;

public class BaseLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("Base logger: " + message);
    }
}
