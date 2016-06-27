package br.ufes.inf.nemo.semed.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.semed.domain.Disease;
import br.ufes.inf.nemo.semed.persistence.DiseaseDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageDiseasesServiceBean extends CrudServiceBean<Disease> implements ManageDiseasesService {

	private static final long serialVersionUID = 1L;

	@EJB private DiseaseDAO diseaseDAO;
	
	@Override
	public BaseDAO<Disease> getDAO() {
		return diseaseDAO;
	}

	@Override
	protected Disease createNewEntity() {
		return new Disease();
	}

}
