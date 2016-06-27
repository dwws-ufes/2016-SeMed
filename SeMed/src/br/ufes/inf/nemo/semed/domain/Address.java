package br.ufes.inf.nemo.semed.domain;

import javax.persistence.Entity;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Address extends PersistentObjectSupport implements Comparable<Address> {

	private static final long serialVersionUID = 1L;
	
	private String street;
	private int number;
	private String district;
	private String city;
	private String state;
	private String zipCode;
	private String description;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int compareTo(Address o) {
		if(o == null || o.getZipCode() == null)		return 1;
		if(getZipCode() == null)					return -1;
		return getZipCode().compareTo(o.getZipCode());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
