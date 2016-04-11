package br.ufes.inf.nemo.semed.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Patient extends Person {

	@OneToMany
	private Set<PatientRecord> patientRecords;

	@OneToMany
	private Set<MedicalRecordItem> medicalRecordItens;

	public Set<PatientRecord> getPatientRecords() {
		return patientRecords;
	}

	public void setPatientRecords(Set<PatientRecord> patientRecords) {
		this.patientRecords = patientRecords;
	}

	public Set<MedicalRecordItem> getMedicalRecordItens() {
		return medicalRecordItens;
	}

	public void setMedicalRecordItens(Set<MedicalRecordItem> medicalRecordItens) {
		this.medicalRecordItens = medicalRecordItens;
	}

}
