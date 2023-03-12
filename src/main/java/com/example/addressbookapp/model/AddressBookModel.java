package com.example.addressbookapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "AddressBook_Table")
public class AddressBookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "first name should not be empty!")
    @Size(min = 2,max = 10,message = "first name must have 2 characters!")
    private String firstName;

    @NotEmpty(message = "last name should not be empty!")
    @Size(min = 2,max = 10,message = "last name must have 2 characters!")
    private String lastName;

    @NotEmpty(message = "address should not be empty!")
    private String address;

    @NotEmpty(message = "email should not be empty!")
    @Email
    private String email;

    @NotEmpty(message = "phone number should not be empty!")
    @Pattern(regexp = "^[0-9]{10}$")
    private String phoneNumber;

    //We are not use validation like @Pattern and @NotEmpty in long data type:-
    private long zipCode;
}