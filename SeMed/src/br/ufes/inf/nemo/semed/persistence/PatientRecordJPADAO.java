package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.PatientRecord;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class PatientRecordJPADAO extends BaseJPADAO<PatientRecord> implements PatientRecordDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<PatientRecord> getDomainClass() {
		return PatientRecord.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
