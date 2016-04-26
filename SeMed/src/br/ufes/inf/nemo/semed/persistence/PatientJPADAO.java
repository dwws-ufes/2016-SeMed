package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.Patient;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class PatientJPADAO extends BaseJPADAO<Patient> implements PatientDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<Patient> getDomainClass() {
		return Patient.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
