package com.soap.app.service;

import java.util.List;

import com.soap.app.model.AddressModel;
public interface IAddressService {
	public void createAddress(AddressModel address);
	public AddressModel getAddress(Long id);
	public List<AddressModel> getAllAddress(); 
	public void updateAddress(AddressModel address); 
	public void deleteAddress(Long id); 
}
