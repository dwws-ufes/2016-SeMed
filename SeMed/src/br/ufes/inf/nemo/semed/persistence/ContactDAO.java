package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.model.Contact;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface ContactDAO extends BaseDAO<Contact> {

}
