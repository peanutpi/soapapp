package com.soap.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap.app.dao.SaleOrderDAO;
import com.soap.app.model.SaleOrderModel;

@Service
public class SaleOrderServiceImp implements ISaleOrderService{
	@Autowired
	private SaleOrderDAO saleOrderDAO;
	
	public void createSaleOrder(SaleOrderModel saleOrder) {
		saleOrderDAO.addSaleOrder(saleOrder);
	}

	public SaleOrderModel getSaleOrder(Long id) {
		return saleOrderDAO.getSaleOrder(id);
	}

	public List<SaleOrderModel> getAllSaleOrder() {
		List<SaleOrderModel> saleOrders = saleOrderDAO.getAllSaleOrders();
		return saleOrders;
	}

	public void updateSaleOrder(SaleOrderModel saleOrder) {
		saleOrderDAO.updateSaleOrder(saleOrder);
	}

	public void deleteSaleOrder(Long id) {
		saleOrderDAO.deleteSaleOrder(id);
	}
}
