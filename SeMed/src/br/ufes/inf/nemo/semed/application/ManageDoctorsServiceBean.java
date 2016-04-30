package br.ufes.inf.nemo.semed.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.semed.domain.Address;
import br.ufes.inf.nemo.semed.domain.Doctor;
import br.ufes.inf.nemo.semed.persistence.DoctorDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageDoctorsServiceBean extends CrudServiceBean<Doctor> implements ManageDoctorsService {

	private static final long serialVersionUID = 1L;

	@EJB private DoctorDAO doctorDAO;
	
	@Override
	public BaseDAO<Doctor> getDAO() {
		return doctorDAO;
	}

	@Override
	protected Doctor createNewEntity() {
		Doctor d = new Doctor();
		d.setAddress(new Address());
		return d;
	}

}
