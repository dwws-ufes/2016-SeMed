package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.model.ClosingReport;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface ClosingReportDAO extends BaseDAO<ClosingReport> {

}
