package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.model.Person;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface PersonDAO extends BaseDAO<Person> {

}
