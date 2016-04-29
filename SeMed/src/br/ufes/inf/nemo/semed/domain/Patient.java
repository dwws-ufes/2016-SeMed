package br.ufes.inf.nemo.semed.domain;

import java.util.Date;

import javax.persistence.CascadeType;
//import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Patient extends PersistentObjectSupport implements Comparable<Patient> {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String surname;
	private String cpf;
	@Temporal(TemporalType.DATE) private Date birthDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
//	@PostConstruct
//	public void init(){
//		if (getAddress() == null){
//			System.out.println("Constructing an address.");
//			setAddress(new Address());
//		} else {
//			System.out.println("Address already exists.");
//		}
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getFullName(){
		return getFirstName() + " " + getSurname();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int compareTo(Patient o) {
		if(o == null)					return 1;
		if(o.getFirstName() == null)	return 1;
		if(getFirstName() == null)		return -1;
		return getFirstName().compareTo(o.getFirstName());
	}

}
