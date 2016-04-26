package br.ufes.inf.nemo.semed.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.semed.model.Patient;
import br.ufes.inf.nemo.semed.persistence.PatientDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManagePatientServiceBean extends CrudServiceBean<Patient> implements ManagePatientService {

	@EJB private PatientDAO patientDAO;
	
	@Override
	public BaseDAO<Patient> getDAO() {
		return patientDAO;
	}

	@Override
	protected Patient createNewEntity() {
		return new Patient();
	}

}
