package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.domain.Doctor;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class DoctorJPADAO extends BaseJPADAO<Doctor> implements DoctorDAO {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext private EntityManager entityManager;

	@Override
	public Class<Doctor> getDomainClass() {
		return Doctor.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
