package br.ufes.inf.nemo.semed.application;

import br.ufes.inf.nemo.semed.model.Person;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

public class ManagePersonServiceBean extends CrudServiceBean<Person> implements ManagePersonService {

	@Override
	public BaseDAO<Person> getDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Person createNewEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
