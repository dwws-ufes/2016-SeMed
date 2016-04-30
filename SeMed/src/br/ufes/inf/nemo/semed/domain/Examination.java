package br.ufes.inf.nemo.semed.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Examination extends PersistentObjectSupport implements Comparable<Examination> {

	private static final long serialVersionUID = 1L;

	private String simptomsAndObservations;
	private String medicePrescription;
	@Temporal(TemporalType.DATE) private Date date;
	
	@ManyToOne private Patient patient;
	@ManyToOne private Doctor doctor;
	
	public Examination() {
		setDate(new Date());
	}
	
	public String getMedicePrescription() {
		return medicePrescription;
	}
	
	public void setMedicePrescription(String medicePrescription) {
		this.medicePrescription = medicePrescription;
	}
	
	public String getSimptomsAndObservations() {
		return simptomsAndObservations;
	}
	
	public void setSimptomsAndObservations(String simptomsAndObservations) {
		this.simptomsAndObservations = simptomsAndObservations;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	@Override
	public int compareTo(Examination o) {
		if(o == null || o.getId() == null)	return 1;
		if(getId() == null)					return 1;
		return Long.compare(getId(), o.getId());
	}
	
}
