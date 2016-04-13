package br.ufes.inf.nemo.semed.model;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(PatientRecord.class)
public class PatientRecord_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<PatientRecord, Date> date;
	public static volatile SingularAttribute<PatientRecord, String> description;
	public static volatile SingularAttribute<PatientRecord, Patient> patient;
	public static volatile SingularAttribute<PatientRecord, Doctor> doctor;
	public static volatile SetAttribute<PatientRecord, MedicalRecordItem> medicalRecordItens;
}
