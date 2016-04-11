package br.ufes.inf.nemo.semed.test.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressUnitTest.class, ClosingReportUnitTest.class,
		ContactUnitTest.class, DoctorUnitTest.class,
		ExaminationReportUnitTest.class, MedicalPrescriptionUnitTeste.class,
		PatientRecordUnitTest.class, PatientUnitTest.class,
		PersonUnitTest.class, MedicalRecordItemUnitTest.class })
public class ModelTests {

}
