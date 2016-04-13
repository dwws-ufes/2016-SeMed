package br.ufes.inf.nemo.semed.model;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Person.class)
public class Person_ extends PersistentObjectSupport_ {
	
	public static volatile SingularAttribute<Person, String> firstName;
	public static volatile SingularAttribute<Person, String> surname;
	public static volatile SingularAttribute<Person, String> cpf;
	public static volatile SingularAttribute<Person, Date> birthDate;
	public static volatile SetAttribute<Person, Contact> contacts;
	public static volatile SingularAttribute<Person, Address> address;
}
