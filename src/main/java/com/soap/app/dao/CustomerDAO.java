package com.soap.app.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soap.app.model.CustomerModel;
import com.soap.app.repository.CustomerCRUDRepository;

@Component
public class CustomerDAO {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerDAO.class);
	@Autowired
	private CustomerCRUDRepository repository;
	
	public void addCustomer(CustomerModel customer) {
		repository.save(customer);
		LOG.info("Customer saved successfully, Customer Details=" + customer);
	}
	
	public void deleteCustomer(Long id) {
		repository.delete(id);
		LOG.info("Customer was successfully removed");
	}
	
	public void updateCustomer(CustomerModel customer) {
		CustomerModel c = repository.findOne(customer.getId());
		c.setCountry(customer.getCountry());
		c.setName(customer.getName());
		repository.save(c);
		LOG.info("Customer updated successfully, Customer Details=" + customer);
	}
	
	public CustomerModel getCustomer(Long id) {
		return repository.findOne(id);		
	}
	
	public List<CustomerModel> getAllCustomers() {
		return repository.findAll();
	}
}
