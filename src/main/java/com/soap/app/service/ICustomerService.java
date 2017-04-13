package com.soap.app.service;

import java.util.List;

import com.soap.app.model.CustomerModel;
public interface ICustomerService {
	public void createCustomer(CustomerModel customer);
	public CustomerModel getCustomer(Long id);
	public List<CustomerModel> getAllCustomer(); 
	public void updateCustomer(CustomerModel customer); 
	public void deleteCustomer(Long id); 
}
