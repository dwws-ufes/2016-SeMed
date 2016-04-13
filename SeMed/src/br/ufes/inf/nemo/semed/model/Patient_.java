package br.ufes.inf.nemo.semed.model;

import javax.persistence.metamodel.SetAttribute;

public class Patient_ extends Person_ {

	public static volatile SetAttribute<Patient, PatientRecord> patientRecords;
	public static volatile SetAttribute<Patient, MedicalRecordItem> medicalRecordItens;
}
