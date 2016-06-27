package br.ufes.inf.nemo.semed.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Disease.class)
public class Disease_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Disease, String> name;
	public static volatile SingularAttribute<Disease, String> referenceResource;
}
