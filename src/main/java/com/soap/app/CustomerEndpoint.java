package com.soap.app;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.app.model.CustomerModel;
import com.soap.app.populator.CustomerPopulator;
import com.soap.app.service.CustomerServiceImp;

import soap.com.app.producing_web_service.AddCustomerRequest;
import soap.com.app.producing_web_service.AddCustomerResponse;
import soap.com.app.producing_web_service.Customer;
import soap.com.app.producing_web_service.GetAllCustomerResponse;
import soap.com.app.producing_web_service.GetCustomerRequest;
import soap.com.app.producing_web_service.GetCustomerResponse;
import soap.com.app.producing_web_service.RemoveCustomerRequest;
import soap.com.app.producing_web_service.RemoveCustomerResponse;
import soap.com.app.producing_web_service.UpdateCustomerRequest;
import soap.com.app.producing_web_service.UpdateCustomerResponse;



@Endpoint
public class CustomerEndpoint {
	private static final String NAMESPACE_URI = "http://com.soap/app/producing-web-service";
	
	@Autowired
	private CustomerServiceImp customerService;
	
	@Autowired
	private CustomerPopulator customerPopulator;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
	@ResponsePayload
	public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request) {
		GetCustomerResponse response = new GetCustomerResponse();
		CustomerModel cm = customerService.getCustomer(request.getId());
		Customer c = customerPopulator.toExternalModel(cm);
		response.setCustomer(c);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCustomerRequest")
	@ResponsePayload
	public AddCustomerResponse addCustomer(@RequestPayload AddCustomerRequest request) {
		AddCustomerResponse response = new AddCustomerResponse();
		CustomerModel c = customerPopulator.toModel(request.getCustomer());
		customerService.createCustomer(c);
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCustomerRequest")
	@ResponsePayload
	public UpdateCustomerResponse updateCustomer(@RequestPayload UpdateCustomerRequest request) {
		UpdateCustomerResponse response = new UpdateCustomerResponse();
		CustomerModel c = customerPopulator.toModel(request.getCustomer());
		customerService.updateCustomer(c);
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeCustomerRequest")
	@ResponsePayload
	public RemoveCustomerResponse removeCustomer(@RequestPayload RemoveCustomerRequest request) {
		RemoveCustomerResponse response = new RemoveCustomerResponse();
		customerService.deleteCustomer(request.getId());
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCustomerRequest")
	@ResponsePayload
	public GetAllCustomerResponse getAllCustomer() {
		GetAllCustomerResponse response = new GetAllCustomerResponse();
		List<CustomerModel> customers = customerService.getAllCustomer();
		response.getResponse().addAll(customerPopulator.toExternalModel(customers));
		return response;
	}
}
