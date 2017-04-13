package com.soap.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soap.app.model.ItemModel;

@Repository
public interface ItemCRUDRepository extends JpaRepository<ItemModel, Long> {

}
