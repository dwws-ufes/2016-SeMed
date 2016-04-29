package br.ufes.inf.nemo.semed.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.semed.domain.Examination;
import br.ufes.inf.nemo.semed.persistence.ExaminationDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageExaminationsServiceBean extends CrudServiceBean<Examination> implements ManageExaminationsService {

	private static final long serialVersionUID = 1L;

	@EJB private ExaminationDAO examinationDAO;
	
	@Override
	public BaseDAO<Examination> getDAO() {
		return examinationDAO;
	}

	@Override
	protected Examination createNewEntity() {
		return new Examination();
	}

}
