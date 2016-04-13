package br.ufes.inf.nemo.semed.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class PatientRecord extends PersistentObjectSupport implements Comparable<PatientRecord> {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String description;

	@ManyToOne
	private Patient patient;

	@ManyToOne
	private Doctor doctor;

	@OneToMany
	Set<MedicalRecordItem> medicalRecordItens;

//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Set<MedicalRecordItem> getMedicalRecordItens() {
		return medicalRecordItens;
	}

	public void setMedicalRecordItens(Set<MedicalRecordItem> medicalRecordItens) {
		this.medicalRecordItens = medicalRecordItens;
	}

	@Override
	public int compareTo(PatientRecord o) {
		return getUuid().compareTo(o.getUuid());
	}

}
