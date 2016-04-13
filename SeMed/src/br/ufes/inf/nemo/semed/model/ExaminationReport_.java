package br.ufes.inf.nemo.semed.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(ExaminationReport.class)
public class ExaminationReport_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<ExaminationReport, String> identification;
	public static volatile SingularAttribute<ExaminationReport, String> physicalExam;
	public static volatile SingularAttribute<ExaminationReport, String> hypotesisAndDiagnoses;
	public static volatile SingularAttribute<ExaminationReport, String> treatmentPlanning;
}
