package com.soap.app.dao;

import java.util.List;

import com.soap.app.model.AddressModel;


public interface IAddressDao {

  void addAddress(AddressModel address);

  void deleteAddress(Long id);

  void updateAddress(AddressModel address);

  AddressModel getAddress(Long id);

  List<AddressModel> getAllAddresss();

}
