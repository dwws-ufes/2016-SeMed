package br.ufes.inf.nemo.semed.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class MedicalPrescription extends MedicalRecordItem {

	private String prescriptionItem;
	private String administrationAndObservations;

	public String getPrescriptionItem() {
		return prescriptionItem;
	}

	public void setPrescriptionItem(String prescriptionItem) {
		this.prescriptionItem = prescriptionItem;
	}

	public String getAdministrationAndObservations() {
		return administrationAndObservations;
	}

	public void setAdministrationAndObservations(
			String administrationAndObservations) {
		this.administrationAndObservations = administrationAndObservations;
	}

}
