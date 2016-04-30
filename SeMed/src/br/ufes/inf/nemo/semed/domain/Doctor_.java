package br.ufes.inf.nemo.semed.domain;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Doctor.class)
public class Doctor_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Doctor, String> firstName;
	public static volatile SingularAttribute<Doctor, String> surname;
	public static volatile SingularAttribute<Doctor, String> cpf;
	public static volatile SingularAttribute<Doctor, Date> birthDate;
	public static volatile SingularAttribute<Doctor, String> professionalId;
	public static volatile SingularAttribute<Doctor, Address> address;
}
