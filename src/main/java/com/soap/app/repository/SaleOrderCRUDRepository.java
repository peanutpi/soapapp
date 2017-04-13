package com.soap.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soap.app.model.SaleOrderModel;

@Repository
public interface SaleOrderCRUDRepository extends JpaRepository<SaleOrderModel, Long> {

}
