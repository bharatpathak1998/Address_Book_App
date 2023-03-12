package com.example.addressbookapp.repository;

import com.example.addressbookapp.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepo extends JpaRepository<AddressBookModel, Integer> {
}
