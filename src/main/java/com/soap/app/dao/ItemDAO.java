package com.soap.app.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soap.app.model.ItemModel;
import com.soap.app.repository.ItemCRUDRepository;

@Component
public class ItemDAO {
	private static final Logger LOG = LoggerFactory.getLogger(ItemDAO.class);
	@Autowired
	private ItemCRUDRepository repository;
	
	public void addItem(ItemModel item) {
		repository.save(item);
		LOG.info("Item saved successfully, Item Details=" + item);
	}
	
	public void deleteItem(Long id) {
		repository.delete(id);
		LOG.info("Item was successfully removed");
	}
	
	public void updateItem(ItemModel item) {
		ItemModel c = repository.findOne(item.getId());
		c.setName(item.getName());
		c.setDescription(item.getDescription());
		repository.save(c);
		LOG.info("Item updated successfully, Item Details=" + item);
	}
	
	public ItemModel getItem(Long id) {
		return repository.findOne(id);		
	}
	
	public List<ItemModel> getAllItems() {
		return repository.findAll();
	}
}
