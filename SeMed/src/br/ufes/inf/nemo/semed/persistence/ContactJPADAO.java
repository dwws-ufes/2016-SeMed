package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.Contact;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class ContactJPADAO extends BaseJPADAO<Contact> implements ContactDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<Contact> getDomainClass() {
		return Contact.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
