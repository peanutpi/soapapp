package com.soap.app.populator;

import org.springframework.stereotype.Component;

import com.soap.app.model.ItemModel;

import soap.com.app.producing_web_service.Item;
@Component
public class ItemPopulator extends AbstractPopulator<Item, ItemModel>{

	@Override
	public ItemModel getModelInstance() {
		return new ItemModel();
	}

	@Override
	public void doPopulateToModel(ItemModel output, Item input) {		
		output.setId(input.getId());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
	}

	@Override
	public Item getExternalModelInstance() {
		return new Item();
	}

	@Override
	public void doPopulateToExternalModel(ItemModel input, Item output) {	
		output.setId(input.getId());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
	}

}
