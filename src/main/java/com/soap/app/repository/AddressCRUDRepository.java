package com.soap.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soap.app.model.AddressModel;

public interface AddressCRUDRepository extends JpaRepository<AddressModel, Long> {

}
