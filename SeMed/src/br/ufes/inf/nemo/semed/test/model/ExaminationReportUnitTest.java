package br.ufes.inf.nemo.semed.test.model;

import org.junit.Test;

import br.ufes.inf.nemo.semed.model.ExaminationReport;

public class ExaminationReportUnitTest {

	@Test
	public final void testGetIdentification() {
		ExaminationReport er = new ExaminationReport();

		er.setIdentification("teste");

		assert (er.getIdentification() == "teste");
	}

	@Test
	public final void testSetIdentification() {
		ExaminationReport er = new ExaminationReport();

		er.setIdentification("teste");

		assert (er.getIdentification() == "teste");
	}

	@Test
	public final void testGetPhysicalExam() {
		ExaminationReport er = new ExaminationReport();

		er.setPhysicalExam("teste");

		assert (er.getPhysicalExam() == "teste");
	}

	@Test
	public final void testSetPhysicalExam() {
		ExaminationReport er = new ExaminationReport();

		er.setPhysicalExam("teste");

		assert (er.getPhysicalExam() == "teste");
	}

	@Test
	public final void testGetHypotesisAndDiagnoses() {
		ExaminationReport er = new ExaminationReport();

		er.setHypotesisAndDiagnoses("teste");

		assert (er.getHypotesisAndDiagnoses() == "teste");
	}

	@Test
	public final void testSetHypotesisAndDiagnoses() {
		ExaminationReport er = new ExaminationReport();

		er.setHypotesisAndDiagnoses("teste");

		assert (er.getHypotesisAndDiagnoses() == "teste");
	}

	@Test
	public final void testGetTreatmentPlanning() {
		ExaminationReport er = new ExaminationReport();

		er.setTreatmentPlanning("teste");

		assert (er.getTreatmentPlanning() == "teste");
	}

	@Test
	public final void testSetTreatmentPlanning() {
		ExaminationReport er = new ExaminationReport();

		er.setTreatmentPlanning("teste");

		assert (er.getTreatmentPlanning() == "teste");
	}

}
