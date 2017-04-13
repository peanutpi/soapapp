package com.soap.app.populator;

import org.springframework.stereotype.Component;

import com.soap.app.model.SaleOrderModel;

import soap.com.app.producing_web_service.SaleOrder;

@Component
public class SaleOrderPopulator extends AbstractPopulator<SaleOrder, SaleOrderModel>{

	@Override
	public SaleOrderModel getModelInstance() {
		return new SaleOrderModel();
	}

	@Override
	public void doPopulateToModel(SaleOrderModel output, SaleOrder input) {		
		output.setId(input.getId());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
	}

	@Override
	public SaleOrder getExternalModelInstance() {
		return new SaleOrder();
	}

	@Override
	public void doPopulateToExternalModel(SaleOrderModel input, SaleOrder output) {	
		output.setId(input.getId());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
	}


}
