package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.ClosingReport;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class ClosingReportJPADAO extends BaseJPADAO<ClosingReport> implements ClosingReportDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<ClosingReport> getDomainClass() {
		return ClosingReport.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
