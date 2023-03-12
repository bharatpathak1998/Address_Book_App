package com.example.addressbookapp.converter;

import com.example.addressbookapp.dto.AddressBookDto;
import com.example.addressbookapp.model.AddressBookModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressBookConverter {

    public AddressBookDto entityToDto(AddressBookModel addressBookModel) {
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setId(addressBookModel.getId());
        addressBookDto.setFirstName(addressBookModel.getFirstName());
        addressBookDto.setLastName(addressBookModel.getLastName());
        addressBookDto.setZipCode(addressBookModel.getZipCode());
        return addressBookDto;
    }

    public List<AddressBookDto> entityToDtoList(List<AddressBookModel> addressBookModel) {
        return addressBookModel.stream().map(this::entityToDto).toList();
    }
}