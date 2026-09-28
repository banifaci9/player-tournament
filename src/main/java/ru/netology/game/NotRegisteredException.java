package ru.netology.game;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String message) {
        super(message);
    }
}
