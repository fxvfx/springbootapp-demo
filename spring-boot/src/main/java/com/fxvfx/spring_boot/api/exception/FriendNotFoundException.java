package com.fxvfx.spring_boot.api.exception;

public class FriendNotFoundException extends RuntimeException {
    private String message;

    public FriendNotFoundException() {}

    public FriendNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

    public FriendNotFoundException(Integer id) {
        super("Friend " + id + " not found.");
    }
}
