package com.soap.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.app.model.AddressModel;
import com.soap.app.model2.AddressModel2;
// import com.soap.app.populator.AddressPopulator;
// import com.soap.app.service.AddressServiceImp;
import com.soap.app.populator.AddressPopulator;
import com.soap.app.service.IAddressService;
import com.soap.app.service2.IAddressService2;

import soap.com.app.producing_web_service.AddAddressRequest;
import soap.com.app.producing_web_service.AddAddressResponse;
import soap.com.app.producing_web_service.Address;
import soap.com.app.producing_web_service.GetAddressRequest;
import soap.com.app.producing_web_service.GetAddressResponse;
import soap.com.app.producing_web_service.GetAllAddressResponse;
import soap.com.app.producing_web_service.RemoveAddressRequest;
import soap.com.app.producing_web_service.RemoveAddressResponse;
import soap.com.app.producing_web_service.UpdateAddressRequest;
import soap.com.app.producing_web_service.UpdateAddressResponse;

@Endpoint
public class AddressEndpoint {
  private static final String NAMESPACE_URI = "http://com.soap/app/producing-web-service";

  @Autowired
  private IAddressService addressService;

  @Autowired
  private IAddressService2 addressService2;

  @Autowired
  private AddressPopulator addressPopulator;

  public AddressEndpoint() {}

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAddressRequest")
  @ResponsePayload
  public GetAddressResponse getAddress(@RequestPayload GetAddressRequest request) {
    GetAddressResponse response = new GetAddressResponse();
    AddressModel cm = addressService.getAddress(request.getId());
    Address c = addressPopulator.toExternalModel(cm);
    response.setAddress(c);
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAddressRequest")
  @ResponsePayload
  public AddAddressResponse addAddress(@RequestPayload AddAddressRequest request) {
    AddAddressResponse response = new AddAddressResponse();
    AddressModel c = addressPopulator.toModel(request.getAddress());
    addressService.createAddress(c);
    response.setResponse("Success!!");
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateAddressRequest")
  @ResponsePayload
  public UpdateAddressResponse updateAddress(@RequestPayload UpdateAddressRequest request) {
    UpdateAddressResponse response = new UpdateAddressResponse();
    AddressModel c = addressPopulator.toModel(request.getAddress());
    addressService.updateAddress(c);
    response.setResponse("Success!!");
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeAddressRequest")
  @ResponsePayload
  public RemoveAddressResponse removeAddress(@RequestPayload RemoveAddressRequest request) {
    RemoveAddressResponse response = new RemoveAddressResponse();
    addressService.deleteAddress(request.getId());
    response.setResponse("Success!!");
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAddressRequest")
  @ResponsePayload
  public GetAllAddressResponse getAllAddress() {
    GetAllAddressResponse response = new GetAllAddressResponse();
    List<AddressModel> addresses1 = addressService.getAllAddress();
    List<AddressModel2> addresses2 = addressService2.getAllAddress();
    for (AddressModel2 addressModel2 : addresses2) {
      AddressModel address = new AddressModel();
      address.setId(addressModel2.getId());
      address.setNo(addressModel2.getNo());
      address.setCity(addressModel2.getCity());
      address.setStreet(addressModel2.getStreet());
      addresses1.add(address);
    }
    response.getResponse().addAll(addressPopulator.toExternalModel(addresses1));
    return response;
  }

}
