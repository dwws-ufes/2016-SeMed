package br.ufes.inf.nemo.semed.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Address.class)
public class Address_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, Integer> number;
	public static volatile SingularAttribute<Address, String> district;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> state;
	public static volatile SingularAttribute<Address, String> zipCode;
}
