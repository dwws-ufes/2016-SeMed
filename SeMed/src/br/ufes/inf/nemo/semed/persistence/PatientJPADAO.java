package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.domain.Patient;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.PersistentObjectNotFoundException;

@Stateless
public class PatientJPADAO extends BaseJPADAO<Patient> implements PatientDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<Patient> getDomainClass() {
		return Patient.class;
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

//	@Override
//	public Patient retrieveById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Patient retrieveByUuid(String uuid)
//			throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void save(Patient object) {
//		// TODO Auto-generated method stub
//		super.save(object);
//
//	}
//
//	@Override
//	public void delete(Patient object) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Patient merge(Patient object) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Patient refresh(Patient object) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
