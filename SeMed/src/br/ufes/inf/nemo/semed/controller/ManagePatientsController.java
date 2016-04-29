package br.ufes.inf.nemo.semed.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.semed.application.ManagePatientsService;
import br.ufes.inf.nemo.semed.domain.Address;
import br.ufes.inf.nemo.semed.domain.Patient;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named @SessionScoped
public class ManagePatientsController extends CrudController<Patient> {

	private static final long serialVersionUID = 1L;

	@EJB private ManagePatientsService managePatientsService;
	
	public ManagePatientsController() {
		viewPath = "/managePatients/";
		bundleName = "msgs";
	}
	
	@Override
	protected CrudService<Patient> getCrudService() {
		return managePatientsService;
	}

	@Override
	protected Patient createNewEntity() {
		Patient p = new Patient();
		p.setAddress(new Address());
		p.getAddress().setStreet("rua");
		p.getAddress().setNumber(0);
		return p;
	}

	@Override
	protected void initFilters() {
	//	addFilter(new SimpleFilter("managePatients.filter.byFirstName", "firstName",
	//			getI18nMessage("msgs", "managePatients.text.filter.byFirstName")));
	}

}
