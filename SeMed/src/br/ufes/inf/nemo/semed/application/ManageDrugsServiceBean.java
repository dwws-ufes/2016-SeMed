package br.ufes.inf.nemo.semed.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.semed.domain.Drug;
import br.ufes.inf.nemo.semed.persistence.DrugDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageDrugsServiceBean extends CrudServiceBean<Drug> implements ManageDrugsService {

	private static final long serialVersionUID = 1L;

	@EJB private DrugDAO drugDAO;
	
	@Override
	public BaseDAO<Drug> getDAO() {
		return drugDAO;
	}

	@Override
	protected Drug createNewEntity() {
		return new Drug();
	}

}
