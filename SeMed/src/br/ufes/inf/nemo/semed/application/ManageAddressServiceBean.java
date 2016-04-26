package br.ufes.inf.nemo.semed.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.semed.model.Address;
import br.ufes.inf.nemo.semed.persistence.AddressDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageAddressServiceBean extends CrudServiceBean<Address> implements ManageAddressService {

	@EJB private AddressDAO addressDAO;
	
	@Override
	public BaseDAO<Address> getDAO() {
		return addressDAO;
	}

	@Override
	protected Address createNewEntity() {
		return new Address();
	}

}
