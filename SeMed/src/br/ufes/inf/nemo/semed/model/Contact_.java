package br.ufes.inf.nemo.semed.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Contact.class)
public class Contact_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Contact, String> contact;
	public static volatile SingularAttribute<Contact, String> contactChannel;
}
