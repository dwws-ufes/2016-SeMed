package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.domain.Doctor;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface DoctorDAO extends BaseDAO<Doctor> {

}
