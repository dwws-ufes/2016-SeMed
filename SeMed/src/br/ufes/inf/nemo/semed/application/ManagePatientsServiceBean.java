package br.ufes.inf.nemo.semed.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.semed.domain.Address;
import br.ufes.inf.nemo.semed.domain.Patient;
import br.ufes.inf.nemo.semed.persistence.PatientDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManagePatientsServiceBean extends CrudServiceBean<Patient> implements ManagePatientsService {

	private static final long serialVersionUID = 1L;
	

	@EJB
	private PatientDAO patientDAO;

	@Override
	public BaseDAO<Patient> getDAO() {
		return patientDAO;
	}

	@Override
	protected Patient createNewEntity() {
		Patient p = new Patient();
		p.setAddress(new Address());
		p.getAddress().setStreet("rua");
		p.getAddress().setNumber(0);
		return p;
	}

	
		
	
}
