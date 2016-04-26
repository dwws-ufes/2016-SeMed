package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.MedicalRecordItem;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class MedicalRecordItemJPADAO extends BaseJPADAO<MedicalRecordItem> implements MedicalRecordItemDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<MedicalRecordItem> getDomainClass() {
		return MedicalRecordItem.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
