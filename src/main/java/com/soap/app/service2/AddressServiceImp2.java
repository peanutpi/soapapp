package com.soap.app.service2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soap.app.model2.AddressModel2;
import com.soap.app.repository2.AddressCRUDRepository2;

@Service
public class AddressServiceImp2 implements IAddressService2 {

  private static final Logger logger = LoggerFactory.getLogger(AddressServiceImp2.class);
  @Autowired
  private AddressCRUDRepository2 repository2;

  @Transactional("datasource2TransactionManager")
  public List<AddressModel2> getAllAddress() {
    List<AddressModel2> addresses2 = repository2.findAll();
    logger.info("from db2 we found :: {} match", addresses2.size());
    return addresses2;
  }
}
