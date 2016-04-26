package br.ufes.inf.nemo.semed.control;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.semed.application.ManagePatientService;
import br.ufes.inf.nemo.semed.exception.InvalidCpfException;
import br.ufes.inf.nemo.semed.model.Patient;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named @SessionScoped
public class ManagePatientController extends CrudController<Patient> {

	@EJB private ManagePatientService managePatientService;
	
	public ManagePatientController() {
		viewPath = "/managePatients/";
		bundleName = "msgs";
	}
	
	@Override
	protected CrudService<Patient> getCrudService() {
		return managePatientService;
	}

	@Override
	protected Patient createNewEntity() {
		return new Patient();
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub

	}

}
