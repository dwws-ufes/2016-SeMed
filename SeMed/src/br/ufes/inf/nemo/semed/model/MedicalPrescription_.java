package br.ufes.inf.nemo.semed.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(MedicalPrescription.class)
public class MedicalPrescription_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<MedicalPrescription, String> prescriptionItem;
	public static volatile SingularAttribute<MedicalPrescription, String> administrationAndObservations;
}
