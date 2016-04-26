package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.Manager;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class ManagerJPADAO extends BaseJPADAO<Manager> implements ManagerDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<Manager> getDomainClass() {
		return Manager.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
