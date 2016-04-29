package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.domain.Address;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class AddressJPADAO extends BaseJPADAO<Address> implements AddressDAO {

	private static final long serialVersionUID = 1L;
	
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
