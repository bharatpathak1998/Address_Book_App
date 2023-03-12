package com.example.addressbookapp.response;

import lombok.Getter;

@Getter
public class AddressBookResponse {

    Object data;
    String token;

    public AddressBookResponse(Object data, String token) {
        this.data = data;
        this.token = token;
    }
}