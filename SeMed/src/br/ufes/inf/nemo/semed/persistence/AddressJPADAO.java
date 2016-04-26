package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.Address;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class AddressJPADAO extends BaseJPADAO<Address> implements AddressDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<Address> getDomainClass() {
		return Address.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
