package br.ufes.inf.nemo.semed.domain;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Examination.class)
public class Examination_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Examination, String> simptomsAndObservations;
	public static volatile SingularAttribute<Examination, String> medicePrescription;
	public static volatile SingularAttribute<Examination, Date> date;
	public static volatile SingularAttribute<Examination, Patient> patient;
	public static volatile SingularAttribute<Examination, Doctor> doctor;
	public static volatile SetAttribute<Examination, Drug> drug;
	public static volatile SetAttribute<Examination, Disease> disease;
}
