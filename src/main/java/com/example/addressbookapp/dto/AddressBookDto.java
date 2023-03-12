package com.example.addressbookapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressBookDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private long zipCode;
}