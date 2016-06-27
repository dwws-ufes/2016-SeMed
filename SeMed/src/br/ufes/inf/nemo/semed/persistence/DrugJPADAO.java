package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.domain.Drug;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class DrugJPADAO extends BaseJPADAO<Drug> implements DrugDAO {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext private EntityManager entityManager;

	@Override
	public Class<Drug> getDomainClass() {
		return Drug.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
