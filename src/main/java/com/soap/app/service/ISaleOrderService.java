package com.soap.app.service;

import java.util.List;

import com.soap.app.model.SaleOrderModel;
public interface ISaleOrderService {
	public void createSaleOrder(SaleOrderModel saleOrder);
	public SaleOrderModel getSaleOrder(Long id);
	public List<SaleOrderModel> getAllSaleOrder(); 
	public void updateSaleOrder(SaleOrderModel saleOrder); 
	public void deleteSaleOrder(Long id); 
}
