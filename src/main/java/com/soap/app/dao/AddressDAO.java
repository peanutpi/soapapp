package com.soap.app.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soap.app.model.AddressModel;
import com.soap.app.repository.AddressCRUDRepository;

@Component
public class AddressDAO implements IAddressDao {
  private static final Logger LOG = LoggerFactory.getLogger(AddressDAO.class);
  @Autowired
  private AddressCRUDRepository repository;

  private static final Logger logger = LoggerFactory.getLogger(AddressDAO.class);

  /* (non-Javadoc)
   * @see com.soap.app.dao.IAddressDao#addAddress(com.soap.app.model.AddressModel)
   */
  @Override
  public void addAddress(AddressModel address) {
    repository.save(address);
    LOG.info("Address saved successfully, Address Details=" + address);
  }

  /* (non-Javadoc)
   * @see com.soap.app.dao.IAddressDao#deleteAddress(java.lang.Long)
   */
  @Override
  public void deleteAddress(Long id) {
    repository.delete(id);
    LOG.info("Address was successfully removed");
  }

  /* (non-Javadoc)
   * @see com.soap.app.dao.IAddressDao#updateAddress(com.soap.app.model.AddressModel)
   */
  @Override
  public void updateAddress(AddressModel address) {
    AddressModel c = repository.findOne(address.getId());
    c.setCity(address.getCity());
    c.setNo(address.getNo());
    c.setStreet(address.getStreet());
    repository.save(c);
    LOG.info("Address updated successfully, Address Details=" + address);
  }

  /* (non-Javadoc)
   * @see com.soap.app.dao.IAddressDao#getAddress(java.lang.Long)
   */
  @Override
  public AddressModel getAddress(Long id) {
    return repository.findOne(id);
  }

  /* (non-Javadoc)
   * @see com.soap.app.dao.IAddressDao#getAllAddresss()
   */
  @Override
  public List<AddressModel> getAllAddresss() {
    List<AddressModel> addresses1 = repository.findAll();
    logger.info("from db1 we found :: {} match", addresses1.size());
    return addresses1;

  }
}
