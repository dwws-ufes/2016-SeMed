package br.ufes.inf.nemo.semed.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Drug.class)
public class Drug_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Drug, String> name;
	public static volatile SingularAttribute<Drug, String> referenceResource;
}
