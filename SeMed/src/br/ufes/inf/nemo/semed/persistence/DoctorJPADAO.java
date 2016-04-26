package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.Doctor;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class DoctorJPADAO extends BaseJPADAO<Doctor> implements DoctorDAO {

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
