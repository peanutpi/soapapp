package com.soap.app.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soap.app.model.SaleOrderModel;
import com.soap.app.repository.SaleOrderCRUDRepository;

@Component
public class SaleOrderDAO {
	private static final Logger LOG = LoggerFactory.getLogger(SaleOrderDAO.class);
	@Autowired
	private SaleOrderCRUDRepository repository;
	
	public void addSaleOrder(SaleOrderModel saleOrder) {
		repository.save(saleOrder);
		LOG.info("SaleOrder saved successfully, SaleOrder Details=" + saleOrder);
	}
	
	public void deleteSaleOrder(Long id) {
		repository.delete(id);
		LOG.info("SaleOrder was successfully removed");
	}
	
	public void updateSaleOrder(SaleOrderModel saleOrder) {
		SaleOrderModel c = repository.findOne(saleOrder.getId());
		c.setName(saleOrder.getName());
		c.setDescription(saleOrder.getDescription());
		repository.save(c);
		LOG.info("SaleOrder updated successfully, SaleOrder Details=" + saleOrder);
	}
	
	public SaleOrderModel getSaleOrder(Long id) {
		return repository.findOne(id);		
	}
	
	public List<SaleOrderModel> getAllSaleOrders() {
		return repository.findAll();
	}
}
