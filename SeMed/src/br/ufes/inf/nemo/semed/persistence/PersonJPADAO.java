package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.Person;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class PersonJPADAO extends BaseJPADAO<Person> implements PersonDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<Person> getDomainClass() {
		return Person.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
