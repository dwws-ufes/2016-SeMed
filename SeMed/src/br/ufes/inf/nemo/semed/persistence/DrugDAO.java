package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.domain.Drug;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface DrugDAO extends BaseDAO<Drug> {

}
