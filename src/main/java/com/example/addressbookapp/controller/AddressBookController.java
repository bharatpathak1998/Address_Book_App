package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDto;
import com.example.addressbookapp.model.AddressBookModel;
import com.example.addressbookapp.response.AddressBookResponse;
import com.example.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    @PostMapping("/post")
    public AddressBookResponse post(@Valid @RequestBody AddressBookModel addressBookModel) {
        return addressBookService.addAddress(addressBookModel);
    }

    @GetMapping("/get/{token}")
    public AddressBookDto getByToken(@PathVariable String token) {
        return addressBookService.viewByToken(token);
    }

    @GetMapping("/getAll")
    public List<AddressBookDto> getAll() {
        return addressBookService.viewAll();
    }

    @PutMapping("/put/{token}")
    public AddressBookDto putByToken(@PathVariable String token, @Valid @RequestBody AddressBookModel addressBookModel) {
        return addressBookService.updateByToken(token, addressBookModel);
    }

    @DeleteMapping("/delete/{token}")
    public String deleteByToken(@PathVariable String token) {
        return addressBookService.deleteByToken(token);
    }
}