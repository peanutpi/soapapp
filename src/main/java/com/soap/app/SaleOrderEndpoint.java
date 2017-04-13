package com.soap.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.app.model.SaleOrderModel;
import com.soap.app.populator.SaleOrderPopulator;
import com.soap.app.service.SaleOrderServiceImp;

import soap.com.app.producing_web_service.AddSaleOrderRequest;
import soap.com.app.producing_web_service.AddSaleOrderResponse;
import soap.com.app.producing_web_service.SaleOrder;
import soap.com.app.producing_web_service.GetSaleOrderRequest;
import soap.com.app.producing_web_service.GetSaleOrderResponse;
import soap.com.app.producing_web_service.GetAllSaleOrderResponse;
import soap.com.app.producing_web_service.RemoveSaleOrderRequest;
import soap.com.app.producing_web_service.RemoveSaleOrderResponse;
import soap.com.app.producing_web_service.UpdateSaleOrderRequest;
import soap.com.app.producing_web_service.UpdateSaleOrderResponse;

@Endpoint
public class SaleOrderEndpoint {
	private static final String NAMESPACE_URI = "http://com.soap/app/producing-web-service";
	
	@Autowired
	private SaleOrderServiceImp saleOrderService;
	
	@Autowired
	private SaleOrderPopulator saleOrderPopulator;

	public SaleOrderEndpoint() {
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSaleOrderRequest")
	@ResponsePayload
	public GetSaleOrderResponse getSaleOrder(@RequestPayload GetSaleOrderRequest request) {
		GetSaleOrderResponse response = new GetSaleOrderResponse();
		SaleOrderModel cm = saleOrderService.getSaleOrder(request.getId());
		SaleOrder c = saleOrderPopulator.toExternalModel(cm);
		response.setSaleOrder(c);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addSaleOrderRequest")
	@ResponsePayload
	public AddSaleOrderResponse addSaleOrder(@RequestPayload AddSaleOrderRequest request) {
		AddSaleOrderResponse response = new AddSaleOrderResponse();
		SaleOrderModel c = saleOrderPopulator.toModel(request.getSaleOrder());
		saleOrderService.createSaleOrder(c);
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateSaleOrderRequest")
	@ResponsePayload
	public UpdateSaleOrderResponse updateSaleOrder(@RequestPayload UpdateSaleOrderRequest request) {
		UpdateSaleOrderResponse response = new UpdateSaleOrderResponse();
		SaleOrderModel c = saleOrderPopulator.toModel(request.getSaleOrder());
		saleOrderService.updateSaleOrder(c);
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeSaleOrderRequest")
	@ResponsePayload
	public RemoveSaleOrderResponse removeSaleOrder(@RequestPayload RemoveSaleOrderRequest request) {
		RemoveSaleOrderResponse response = new RemoveSaleOrderResponse();
		saleOrderService.deleteSaleOrder(request.getId());
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllSaleOrderRequest")
	@ResponsePayload
	public GetAllSaleOrderResponse getAllSaleOrder() {
		GetAllSaleOrderResponse response = new GetAllSaleOrderResponse();
		List<SaleOrderModel> saleOrders = saleOrderService.getAllSaleOrder();
		response.getResponse().addAll(saleOrderPopulator.toExternalModel(saleOrders));
		return response;
	}
}
