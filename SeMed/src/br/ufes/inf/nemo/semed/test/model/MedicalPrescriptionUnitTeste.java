package br.ufes.inf.nemo.semed.test.model;

import org.junit.Test;

import br.ufes.inf.nemo.semed.model.MedicalPrescription;

public class MedicalPrescriptionUnitTeste {

	@Test
	public final void testGetPrescriptionItem() {
		MedicalPrescription mp = new MedicalPrescription();

		mp.setPrescriptionItem("teste");

		assert (mp.getPrescriptionItem() == "teste");
	}

	@Test
	public final void testSetPrescriptionItem() {
		MedicalPrescription mp = new MedicalPrescription();

		mp.setPrescriptionItem("teste");

		assert (mp.getPrescriptionItem() == "teste");
	}

	@Test
	public final void testGetAdministrationAndObservations() {
		MedicalPrescription mp = new MedicalPrescription();

		mp.setAdministrationAndObservations("teste");

		assert (mp.getAdministrationAndObservations() == "teste");
	}

	@Test
	public final void testSetAdministrationAndObservations() {
		MedicalPrescription mp = new MedicalPrescription();

		mp.setAdministrationAndObservations("teste");

		assert (mp.getAdministrationAndObservations() == "teste");
	}

}
