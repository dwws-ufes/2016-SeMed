package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.domain.Examination;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class ExaminationJPADAO extends BaseJPADAO<Examination> implements ExaminationDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<Examination> getDomainClass() {
		return Examination.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
