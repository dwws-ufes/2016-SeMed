package br.ufes.inf.nemo.semed.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.semed.application.ManageExaminationsService;
import br.ufes.inf.nemo.semed.domain.Doctor;
import br.ufes.inf.nemo.semed.domain.Examination;
import br.ufes.inf.nemo.semed.domain.Patient;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named @SessionScoped
public class ManageExaminationsController extends CrudController<Examination> {

	private static final long serialVersionUID = 1L;

	@EJB private ManageExaminationsService manageExaminationsService;
	
	private Patient selectedPatient;
	private Doctor selectedDoctor;
	
	
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
	
	public Object getSelectedItem() {
		return getSelectedPatient();
	}
	
	public void setSelectedItem(Object o){
		if(o instanceof Patient){
			setSelectedPatient((Patient) o);
			return ;
		} 
		else if(o instanceof Doctor){
			setSelectedDoctor((Doctor) o);
			return ;
		}
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
	public String save(){
		selectedEntity.setPatient(getSelectedPatient());
		selectedEntity.setDoctor(getSelectedDoctor());
		return super.save();
	}

}
