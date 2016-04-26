package br.ufes.inf.nemo.semed.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.model.Patient;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManagePatientService extends CrudService<Patient> {

}
