package com.soap.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.app.model.ItemModel;
import com.soap.app.populator.ItemPopulator;
import com.soap.app.service.ItemServiceImp;

import soap.com.app.producing_web_service.AddItemRequest;
import soap.com.app.producing_web_service.AddItemResponse;
import soap.com.app.producing_web_service.Item;
import soap.com.app.producing_web_service.GetItemRequest;
import soap.com.app.producing_web_service.GetItemResponse;
import soap.com.app.producing_web_service.GetAllItemResponse;
import soap.com.app.producing_web_service.RemoveItemRequest;
import soap.com.app.producing_web_service.RemoveItemResponse;
import soap.com.app.producing_web_service.UpdateItemRequest;
import soap.com.app.producing_web_service.UpdateItemResponse;

@Endpoint
public class ItemEndpoint {
	private static final String NAMESPACE_URI = "http://com.soap/app/producing-web-service";
	
	@Autowired
	private ItemServiceImp itemService;
	
	@Autowired
	private ItemPopulator itemPopulator;

	public ItemEndpoint() {
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getItemRequest")
	@ResponsePayload
	public GetItemResponse getItem(@RequestPayload GetItemRequest request) {
		GetItemResponse response = new GetItemResponse();
		ItemModel cm = itemService.getItem(request.getId());
		Item c = itemPopulator.toExternalModel(cm);
		response.setItem(c);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addItemRequest")
	@ResponsePayload
	public AddItemResponse addItem(@RequestPayload AddItemRequest request) {
		AddItemResponse response = new AddItemResponse();
		ItemModel c = itemPopulator.toModel(request.getItem());
		itemService.createItem(c);
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateItemRequest")
	@ResponsePayload
	public UpdateItemResponse updateItem(@RequestPayload UpdateItemRequest request) {
		UpdateItemResponse response = new UpdateItemResponse();
		ItemModel c = itemPopulator.toModel(request.getItem());
		itemService.updateItem(c);
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeItemRequest")
	@ResponsePayload
	public RemoveItemResponse removeItem(@RequestPayload RemoveItemRequest request) {
		RemoveItemResponse response = new RemoveItemResponse();
		itemService.deleteItem(request.getId());
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllItemRequest")
	@ResponsePayload
	public GetAllItemResponse getAllItem() {
		GetAllItemResponse response = new GetAllItemResponse();
		List<ItemModel> items = itemService.getAllItem();
		response.getResponse().addAll(itemPopulator.toExternalModel(items));
		return response;
	}
}
