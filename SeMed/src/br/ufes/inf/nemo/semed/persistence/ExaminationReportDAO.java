package br.ufes.inf.nemo.semed.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.model.ExaminationReport;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface ExaminationReportDAO extends BaseDAO<ExaminationReport> {

}
