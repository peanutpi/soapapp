package com.soap.app.service;

import java.util.List;

import com.soap.app.model.ItemModel;
public interface IItemService {
	public void createItem(ItemModel item);
	public ItemModel getItem(Long id);
	public List<ItemModel> getAllItem(); 
	public void updateItem(ItemModel item); 
	public void deleteItem(Long id); 
}
