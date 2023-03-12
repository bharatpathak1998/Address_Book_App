package com.example.addressbookapp.service;

import com.example.addressbookapp.converter.AddressBookConverter;
import com.example.addressbookapp.dto.AddressBookDto;
import com.example.addressbookapp.model.AddressBookModel;
import com.example.addressbookapp.repository.AddressBookRepo;
import com.example.addressbookapp.response.AddressBookResponse;
import com.example.addressbookapp.util.EmailService;
import com.example.addressbookapp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    AddressBookRepo addressBookRepo;

    @Autowired
    AddressBookConverter addressBookConverter;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    EmailService emailService;

    public AddressBookResponse addAddress(AddressBookModel addressBookModel) {
        AddressBookModel save = addressBookRepo.save(addressBookModel);
        String token = tokenUtil.createToken(save);
        emailService.sendEmail(addressBookModel.getEmail(), "It's Your Token : " + token, "TOKEN");
        AddressBookDto addressBookDto = addressBookConverter.entityToDto(save);
        return new AddressBookResponse(addressBookDto, token);
    }

    public AddressBookDto viewByToken(String token) {
        Integer id = tokenUtil.decodeToken(token);
        AddressBookModel addressBookModel = addressBookRepo.findById(id).get();
        return addressBookConverter.entityToDto(addressBookModel);
    }

    public List<AddressBookDto> viewAll() {
        return addressBookConverter.entityToDtoList(addressBookRepo.findAll());
    }

    public AddressBookDto updateByToken(String token, AddressBookModel addressBookModel) {
        Integer id = tokenUtil.decodeToken(token);
        addressBookModel.setId(id);
        return addressBookConverter.entityToDto(addressBookRepo.save(addressBookModel));
    }

    public String deleteByToken(String token) {
        Integer id = tokenUtil.decodeToken(token);
        addressBookRepo.deleteById(id);
        return "Address deleted Successfully";
    }
}