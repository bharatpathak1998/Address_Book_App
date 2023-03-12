package com.example.addressbookapp.exception;

public class TokenNotFoundException extends RuntimeException {

    public TokenNotFoundException() {
        super("Please Enter Valid Token!");
    }
}