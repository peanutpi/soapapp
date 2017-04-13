package com.soap.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap.app.dao.CustomerDAO;
import com.soap.app.model.CustomerModel;

@Service
public class CustomerServiceImp implements ICustomerService{
	@Autowired
	private CustomerDAO customerDAO;
	
	public void createCustomer(CustomerModel customer) {
		customerDAO.addCustomer(customer);
	}

	public CustomerModel getCustomer(Long id) {
		return customerDAO.getCustomer(id);
	}

	public List<CustomerModel> getAllCustomer() {
		List<CustomerModel> customers = customerDAO.getAllCustomers();
		return customers;
	}

	public void updateCustomer(CustomerModel customer) {
		customerDAO.updateCustomer(customer);
	}

	public void deleteCustomer(Long id) {
		customerDAO.deleteCustomer(id);
	}
}
