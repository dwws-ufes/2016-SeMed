package br.ufes.inf.nemo.semed.test.model;

import org.junit.Test;

import br.ufes.inf.nemo.semed.model.Doctor;

public class DoctorUnitTest {

	@Test
	public final void testGetProfessionalId() {
		Doctor d1 = new Doctor();

		d1.setProfessionalId("teste");

		assert (d1.getProfessionalId() == "teste");
	}

	@Test
	public final void testSetProfessionalId() {
		Doctor d1 = new Doctor();

		d1.setProfessionalId("teste");

		assert (d1.getProfessionalId() == "teste");
	}

}
