package com.soap.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soap.app.model.CustomerModel;

@Repository
public interface CustomerCRUDRepository extends JpaRepository<CustomerModel, Long> {

}
