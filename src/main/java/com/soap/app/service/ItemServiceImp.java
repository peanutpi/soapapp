package com.soap.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap.app.dao.ItemDAO;
import com.soap.app.model.ItemModel;

@Service
public class ItemServiceImp implements IItemService{
	@Autowired
	private ItemDAO itemDAO;
	
	public void createItem(ItemModel item) {
		itemDAO.addItem(item);
	}

	public ItemModel getItem(Long id) {
		return itemDAO.getItem(id);
	}

	public List<ItemModel> getAllItem() {
		List<ItemModel> items = itemDAO.getAllItems();
		return items;
	}

	public void updateItem(ItemModel item) {
		itemDAO.updateItem(item);
	}

	public void deleteItem(Long id) {
		itemDAO.deleteItem(id);
	}
}
