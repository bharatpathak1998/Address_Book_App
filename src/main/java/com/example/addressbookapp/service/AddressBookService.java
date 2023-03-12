package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDto;
import com.example.addressbookapp.model.AddressBookModel;
import com.example.addressbookapp.response.AddressBookResponse;

import java.util.List;

public interface AddressBookService {

    AddressBookResponse addAddress(AddressBookModel addressBookModel);

    AddressBookDto viewByToken(String token);

    List<AddressBookDto> viewAll();

    AddressBookDto updateByToken(String token, AddressBookModel addressBookModel);

    String deleteByToken(String token);
}