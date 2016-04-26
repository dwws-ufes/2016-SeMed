package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.model.MedicalRecordItem;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface MedicalRecordItemDAO extends BaseDAO<MedicalRecordItem> {

}
