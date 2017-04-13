package com.soap.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class AddressModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADD_SEQ")
    @SequenceGenerator(sequenceName = "address_seq", allocationSize = 1, name = "ADD_SEQ")
	private Long id;
	private String city;
	private String street;
	private String no;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String number) {
		this.no = number;
	}
}
