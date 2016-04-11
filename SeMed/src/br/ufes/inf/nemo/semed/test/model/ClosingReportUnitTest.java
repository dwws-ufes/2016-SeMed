package br.ufes.inf.nemo.semed.test.model;

import org.junit.Test;

import br.ufes.inf.nemo.semed.model.ClosingReport;

public class ClosingReportUnitTest {

	@Test
	public final void testGetResume() {
		ClosingReport cr = new ClosingReport();

		cr.setResume("teste");

		assert (cr.getResume() == "teste");
	}

	@Test
	public final void testSetResume() {
		ClosingReport cr = new ClosingReport();

		cr.setResume("teste");

		assert (cr.getResume() == "teste");
	}

}
