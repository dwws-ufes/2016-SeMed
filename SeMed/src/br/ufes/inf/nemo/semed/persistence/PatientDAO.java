package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.model.Patient;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface PatientDAO extends BaseDAO<Patient> {

}
