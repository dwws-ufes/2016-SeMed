package br.ufes.inf.nemo.semed.domain;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Patient.class)
public class Patient_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Patient, String> firstName;
	public static volatile SingularAttribute<Patient, String> surname;
	public static volatile SingularAttribute<Patient, String> cpf;
	public static volatile SingularAttribute<Patient, Date> birthDate;
	public static volatile SingularAttribute<Patient, Address> address;
}
