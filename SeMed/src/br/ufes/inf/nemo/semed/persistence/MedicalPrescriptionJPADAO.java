package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.MedicalPrescription;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class MedicalPrescriptionJPADAO extends BaseJPADAO<MedicalPrescription> implements MedicalPrescriptionDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<MedicalPrescription> getDomainClass() {
		return MedicalPrescription.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
