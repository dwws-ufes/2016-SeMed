package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.semed.model.ExaminationReport;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO;

@Stateless
public class ExaminationReportJPADAO extends BaseJPADAO<ExaminationReport> implements ExaminationReportDAO {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Class<ExaminationReport> getDomainClass() {
		return ExaminationReport.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
