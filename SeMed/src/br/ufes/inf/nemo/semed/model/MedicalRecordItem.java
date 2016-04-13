package br.ufes.inf.nemo.semed.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MedicalRecordItem extends PersistentObjectSupport implements Comparable<MedicalRecordItem> {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;

	@ManyToOne
	private Doctor doctor;

	@ManyToOne
	private Patient patient;

//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public long getId() {
//		return id;
//	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public int compareTo(MedicalRecordItem o) {
		return getUuid().compareTo(o.getUuid());
	}
	
}
