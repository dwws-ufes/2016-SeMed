package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.domain.Semester;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.PersistentObjectNotFoundException;

@Stateless
public class SemesterJPADAO extends BaseJPADAO<Semester> implements SemesterDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<Semester> getDomainClass() {
		return Semester.class;
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

//	@Override
//	public Semester retrieveById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Semester retrieveByUuid(String uuid)
//			throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void save(Semester object) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void delete(Semester object) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Semester merge(Semester object) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Semester refresh(Semester object) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
