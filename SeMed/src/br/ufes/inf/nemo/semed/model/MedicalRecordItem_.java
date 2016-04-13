package br.ufes.inf.nemo.semed.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(MedicalRecordItem.class)
public class MedicalRecordItem_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<MedicalRecordItem, Doctor> doctor;
	public static volatile SingularAttribute<MedicalRecordItem, Patient> patient;
}
