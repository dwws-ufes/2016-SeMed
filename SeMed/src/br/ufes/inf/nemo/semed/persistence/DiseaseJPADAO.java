package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.domain.Disease;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class DiseaseJPADAO extends BaseJPADAO<Disease> implements DiseaseDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<Disease> getDomainClass() {
		return Disease.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
