package br.ufes.inf.nemo.semed.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class ExaminationReport extends MedicalRecordItem {

	private String identification;
	private String physicalExam;
	private String hypotesisAndDiagnoses;
	private String treatmentPlanning;

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getPhysicalExam() {
		return physicalExam;
	}

	public void setPhysicalExam(String physicalExam) {
		this.physicalExam = physicalExam;
	}

	public String getHypotesisAndDiagnoses() {
		return hypotesisAndDiagnoses;
	}

	public void setHypotesisAndDiagnoses(String hypotesisAndDiagnoses) {
		this.hypotesisAndDiagnoses = hypotesisAndDiagnoses;
	}

	public String getTreatmentPlanning() {
		return treatmentPlanning;
	}

	public void setTreatmentPlanning(String treatmentPlanning) {
		this.treatmentPlanning = treatmentPlanning;
	}

}
