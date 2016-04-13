package br.ufes.inf.nemo.semed.test.model;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.ufes.inf.nemo.semed.exception.InvalidCpfException;
import br.ufes.inf.nemo.semed.model.Doctor;
import br.ufes.inf.nemo.semed.model.MedicalPrescription;
import br.ufes.inf.nemo.semed.model.MedicalRecordItem;
import br.ufes.inf.nemo.semed.model.Patient;
import br.ufes.inf.nemo.semed.model.PatientRecord;

public class PatientRecordUnitTest {

//	@Test
//	public final void testGetId() {
//		PatientRecord pr = new PatientRecord();
//
//		pr.setId(1);
//
//		assert (pr.getId() == 1);
//	}
//
//	@Test
//	public final void testSetId() {
//		PatientRecord pr = new PatientRecord();
//
//		pr.setId(1);
//
//		assert (pr.getId() == 1);
//	}
//
//	@Test
//	public final void testGetDate() {
//		PatientRecord pr = new PatientRecord();
//
//		pr.setDate(new Date("01/01/1900"));
//
//		assert (pr.getDate() == new Date("01/01/1900"));
//	}
//
//	@Test
//	public final void testSetDate() {
//		PatientRecord pr = new PatientRecord();
//
//		pr.setDate(new Date("01/01/1900"));
//
//		assert (pr.getDate() == new Date("01/01/1900"));
//	}
//
//	@Test
//	public final void testGetDescription() {
//		PatientRecord pr = new PatientRecord();
//
//		pr.setDescription("teste");
//
//		assert (pr.getDescription() == "teste");
//	}
//
//	@Test
//	public final void testSetDescription() {
//		PatientRecord pr = new PatientRecord();
//
//		pr.setDescription("teste");
//
//		assert (pr.getDescription() == "teste");
//	}
//
//	@Test
//	public final void testSetPatient() {
//		PatientRecord pr = new PatientRecord();
//		Patient p1 = new Patient();
//		p1.setId(1);
//		try {
//			p1.setCpf("797.450.537-08");
//		} catch (InvalidCpfException e) {
//			fail(e.getMessage());
//		}
//
//		pr.setPatient(p1);
//
//		assert (pr.getPatient().equals(p1));
//	}
//
//	@Test
//	public final void testGetPatient() {
//		PatientRecord pr = new PatientRecord();
//		Patient p1 = new Patient();
//		p1.setId(1);
//		try {
//			p1.setCpf("797.450.537-08");
//		} catch (InvalidCpfException e) {
//			fail(e.getMessage());
//		}
//
//		pr.setPatient(p1);
//
//		assert (pr.getPatient().equals(p1));
//	}
//
//	@Test
//	public final void testGetDoctor() {
//		PatientRecord pr = new PatientRecord();
//
//		Doctor d1 = new Doctor();
//		d1.setProfessionalId("teste");
//
//		pr.setDoctor(d1);
//
//		assert (pr.getDoctor().getProfessionalId() == "teste");
//	}
//
//	@Test
//	public final void testSetDoctor() {
//		PatientRecord pr = new PatientRecord();
//
//		Doctor d1 = new Doctor();
//		d1.setProfessionalId("teste");
//
//		pr.setDoctor(d1);
//
//		assert (pr.getDoctor().getProfessionalId() == "teste");
//	}
//
//	@Test
//	public final void testGetMedicalRecordItens() {
//		PatientRecord pr = new PatientRecord();
//
//		MedicalRecordItem mri = new MedicalPrescription();
//		((MedicalPrescription) mri).setPrescriptionItem("teste");
//
//		Set<MedicalRecordItem> itens = new HashSet<MedicalRecordItem>();
//		itens.add(mri);
//
//		pr.setMedicalRecordItens(itens);
//
//		assert (pr.getMedicalRecordItens().contains(mri));
//	}
//
//	@Test
//	public final void testSetMedicalRecordItens() {
//		PatientRecord pr = new PatientRecord();
//
//		MedicalRecordItem mri = new MedicalPrescription();
//		((MedicalPrescription) mri).setPrescriptionItem("teste");
//
//		Set<MedicalRecordItem> itens = new HashSet<MedicalRecordItem>();
//		itens.add(mri);
//
//		pr.setMedicalRecordItens(itens);
//
//		assert (pr.getMedicalRecordItens().contains(mri));
//	}

}
