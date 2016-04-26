package br.ufes.inf.nemo.semed.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.semed.application.ManageAddressService;
import br.ufes.inf.nemo.semed.model.Address;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named @SessionScoped
public class ManageAddressController extends CrudController<Address> {

	@EJB private ManageAddressService manageAddressService;
	
	@Override
	protected CrudService<Address> getCrudService() {
		return manageAddressService;
	}

	@Override
	protected Address createNewEntity() {
		return new Address();
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub

	}

}
