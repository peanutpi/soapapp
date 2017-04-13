package com.soap.app.populator;

import org.springframework.stereotype.Component;

import com.soap.app.model.CustomerModel;

import soap.com.app.producing_web_service.Customer;
@Component
public class CustomerPopulator extends AbstractPopulator<Customer, CustomerModel>{

	@Override
	public CustomerModel getModelInstance() {
		return new CustomerModel();
	}

	@Override
	public void doPopulateToModel(CustomerModel output, Customer input) {		
		output.setCountry(input.getCountry());
		output.setId(input.getId());
		output.setName(input.getName());
	}

	@Override
	public Customer getExternalModelInstance() {
		return new Customer();
	}

	@Override
	public void doPopulateToExternalModel(CustomerModel input, Customer output) {	
		output.setCountry(input.getCountry());
		output.setId(input.getId());
		output.setName(input.getName());
	}

}
