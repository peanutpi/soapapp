package com.soap.app.populator;

import org.springframework.stereotype.Component;

import com.soap.app.model.AddressModel;

import soap.com.app.producing_web_service.Address;
@Component
public class AddressPopulator extends AbstractPopulator<Address, AddressModel>{

	@Override
	public AddressModel getModelInstance() {
		return new AddressModel();
	}

	@Override
	public void doPopulateToModel(AddressModel output, Address input) {		
		output.setId(input.getId());
		output.setCity(input.getCity());
		output.setNo(input.getNumber());
		output.setStreet(input.getStreet());
	}

	@Override
	public Address getExternalModelInstance() {
		return new Address();
	}

	@Override
	public void doPopulateToExternalModel(AddressModel input, Address output) {	
		output.setId(input.getId());
		output.setCity(input.getCity());
		output.setNumber(input.getNo());
		output.setStreet(input.getStreet());
	}

}
