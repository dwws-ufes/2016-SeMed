package br.ufes.inf.nemo.semed.test.model;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.ufes.inf.nemo.semed.model.MedicalPrescription;
import br.ufes.inf.nemo.semed.model.MedicalRecordItem;
import br.ufes.inf.nemo.semed.model.Patient;
import br.ufes.inf.nemo.semed.model.PatientRecord;

public class PatientUnitTest {

	@Test
	public final void testGetPatientRecords() {
		Patient p1 = new Patient();

		PatientRecord r1 = new PatientRecord();
		r1.setDescription("Teste");

		Set<PatientRecord> prs = new HashSet<PatientRecord>();
		prs.add(r1);

		assert (p1.getPatientRecords().contains(r1));

	}

	@Test
	public final void testSetPatientRecords() {
		Patient p1 = new Patient();

		PatientRecord r1 = new PatientRecord();
		r1.setDescription("Teste");

		Set<PatientRecord> prs = new HashSet<PatientRecord>();
		prs.add(r1);

		assert (p1.getPatientRecords().contains(r1));
	}

	@Test
	public final void testGetMedicalRecordItens() {
		Patient p1 = new Patient();

		MedicalRecordItem r1 = new MedicalPrescription();

		Set<MedicalRecordItem> prs = new HashSet<MedicalRecordItem>();
		prs.add(r1);

		assert (p1.getMedicalRecordItens().contains(r1));
	}

	@Test
	public final void testSetMedicalRecordItens() {
		Patient p1 = new Patient();

		MedicalRecordItem r1 = new MedicalPrescription();

		Set<MedicalRecordItem> prs = new HashSet<MedicalRecordItem>();
		prs.add(r1);

		assert (p1.getMedicalRecordItens().contains(r1));
	}

}
