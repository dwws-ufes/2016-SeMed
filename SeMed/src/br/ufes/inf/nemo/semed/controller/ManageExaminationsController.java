package br.ufes.inf.nemo.semed.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.semed.application.ManageExaminationsService;
import br.ufes.inf.nemo.semed.domain.Disease;
import br.ufes.inf.nemo.semed.domain.Doctor;
import br.ufes.inf.nemo.semed.domain.Drug;
import br.ufes.inf.nemo.semed.domain.Examination;
import br.ufes.inf.nemo.semed.domain.Patient;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageExaminationsController extends CrudController<Examination> {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManageExaminationsService manageExaminationsService;

	private Patient selectedPatient;
	private Doctor selectedDoctor;
	private List<Disease> selectedDiseases;
	private List<Drug> selectedDrugs;

	public ManageExaminationsController() {
		viewPath = "/manageExaminations/";
		bundleName = "msgs";
	}

	public Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public Doctor getSelectedDoctor() {
		return selectedDoctor;
	}

	public void setSelectedDoctor(Doctor selectedDoctor) {
		this.selectedDoctor = selectedDoctor;
	}

	public List<Disease> getSelectedDiseases() {
		return selectedDiseases;
	}

	public void setSelectedDiseases(List<Disease> selectedDiseases) {
		this.selectedDiseases = selectedDiseases;
	}

	public List<Drug> getSelectedDrugs() {
		return selectedDrugs;
	}

	public void setSelectedDrugs(List<Drug> selectedDrugs) {
		this.selectedDrugs = selectedDrugs;
	}

	public Object getSelectedItem() {
		return getSelectedPatient();
	}

	public void setSelectedItem(Object o) {
		if (o instanceof Patient) {
			setSelectedPatient((Patient) o);
			return;
		} else if (o instanceof Doctor) {
			setSelectedDoctor((Doctor) o);
			return;
		} else if (o instanceof Drug) {
			addSelectedDrugs((Drug) o);
			return;
		} else if (o instanceof Disease) {
			addSelectedDiseases((Disease) o);
			return;
		}

	}

	private void addSelectedDiseases(Disease o) {
		if (this.selectedDiseases == null) {
			this.selectedDiseases = new ArrayList<Disease>();
		}
		this.selectedDiseases.add(o);

	}
	
	private void addSelectedDrugs(Drug o) {
		if (this.selectedDrugs == null) {
			this.selectedDrugs = new ArrayList<Drug>();
		}
		this.selectedDrugs.add(o);

	}

	@Override
	protected CrudService<Examination> getCrudService() {
		return manageExaminationsService;
	}

	@Override
	protected Examination createNewEntity() {
		return new Examination();
	}

	@Override
	protected void initFilters() {
		addFilter(new SimpleFilter("manageExaminations.filter.byPatient", "patient.firstName",
				getI18nMessage("msgs", "manageExaminations.text.filter.byPatient")));
		addFilter(new SimpleFilter("manageExaminations.filter.byDoctor", "doctor.firstName",
				getI18nMessage("msgs", "manageExaminations.text.filter.byDoctor")));

	}

	@Override
	public String save() {
		selectedEntity.setPatient(getSelectedPatient());
		selectedEntity.setDoctor(getSelectedDoctor());
		selectedEntity.setDiseases(getSelectedDiseases());
		return super.save();
	}

	/*
	 * public void suggestDiseaseDetail() {
	 * 
	 * String name = this.selectedEntity.getDisease();
	 * 
	 * if (name != null && name.length() > 3) { String query =
	 * "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +
	 * "PREFIX dbpprop: <http://dbpedia.org/property/> " + "SELECT ?desc " +
	 * "WHERE { " + "?x a dbpedia-owl:Disease ; " + "dbpprop:name ?name ; " +
	 * "dbpedia-owl:abstract ?desc . " + "FILTER (lcase(str(?name)) = \"" +
	 * name.toLowerCase() + "\") " +
	 * "FILTER (langMatches(lang(?desc), \"EN\")) " + "}"; QueryExecution
	 * queryExecution =
	 * QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
	 * ResultSet results = queryExecution.execSelect(); if (results.hasNext()) {
	 * QuerySolution querySolution = results.next(); Literal literal =
	 * querySolution.getLiteral("desc"); this.selectedEntity.setDiseaseDetail(""
	 * + literal.getValue()); } } }
	 */

}
