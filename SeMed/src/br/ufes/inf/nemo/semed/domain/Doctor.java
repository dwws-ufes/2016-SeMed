package br.ufes.inf.nemo.semed.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Doctor extends PersistentObjectSupport implements Comparable<Doctor> {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String surname;
	private String cpf;
	@Temporal(TemporalType.DATE) private Date birthDate;
	private String professionalId;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

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

	public String getProfessionalId() {
		return professionalId;
	}

	public void setProfessionalId(String professionalId) {
		this.professionalId = professionalId;
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
	public int compareTo(Doctor o) {
		if(o == null)					return 1;
		if(o.getFirstName() == null)	return 1;
		if(getFirstName() == null)		return -1;
		return getFirstName().compareTo(o.getFirstName());
	}

}
