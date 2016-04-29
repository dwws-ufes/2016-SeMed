package br.ufes.inf.nemo.semed.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.domain.Examination;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageExaminationsService extends CrudService<Examination> {

}
