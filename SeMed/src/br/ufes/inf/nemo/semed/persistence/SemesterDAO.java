package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.domain.Semester;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface SemesterDAO extends BaseDAO<Semester> {

}
