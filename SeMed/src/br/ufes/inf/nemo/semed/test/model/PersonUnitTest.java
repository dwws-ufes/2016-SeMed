package br.ufes.inf.nemo.semed.test.model;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import br.ufes.inf.nemo.semed.exception.InvalidCpfException;
import br.ufes.inf.nemo.semed.model.Address;
import br.ufes.inf.nemo.semed.model.Contact;
import br.ufes.inf.nemo.semed.model.Patient;
import br.ufes.inf.nemo.semed.model.Person;

public class PersonUnitTest {

//	@Test
//	public void testHashCode() {
//		Person p1 = new Patient();
//		Person p2 = new Patient();
//
//		p1.setId(1);
//		try {
//			p1.setCpf("797.450.537-08");
//		} catch (InvalidCpfException e) {
//			fail("CPF Invalido");
//		}
//
//		p2.setId(1);
//		try {
//			p2.setCpf("797.450.537-08");
//		} catch (InvalidCpfException e) {
//			fail("CPF Invalido");
//		}
//
//		assert (p1.hashCode() == p2.hashCode());
//	}
//
//	@Test
//	public void testGetId() {
//		Person p1 = new Patient();
//
//		p1.setId(1);
//
//		assert (p1.getId() == 1);
//	}
//
//	@Test
//	public void testSetId() {
//		Person p1 = new Patient();
//
//		p1.setId(1);
//
//		assert (p1.getId() == 1);
//	}
//
//	@Test
//	public void testGetFirstName() {
//		Person p1 = new Patient();
//
//		p1.setFirstName("Joao");
//
//		assert (p1.getFirstName() == "Joao");
//	}
//
//	@Test
//	public void testSetFirstName() {
//		Person p1 = new Patient();
//
//		p1.setFirstName("Joao");
//
//		assert (p1.getFirstName() == "Joao");
//	}
//
//	@Test
//	public void testGetSurname() {
//		Person p1 = new Patient();
//
//		p1.setSurname("Silva");
//
//		assert (p1.getSurname() == "Silva");
//	}
//
//	@Test
//	public void testSetSurname() {
//		Person p1 = new Patient();
//
//		p1.setSurname("Silva");
//
//		assert (p1.getSurname() == "Silva");
//	}
//
//	@Test
//	public void testGetCpf() {
//		Person p1 = new Patient();
//
//		try {
//			p1.setCpf("249.021.251-61");
//		} catch (InvalidCpfException e) {
//			fail("CPF Invalido");
//		}
//
//		assert (p1.getCpf() == "24902125161");
//	}
//
//	@Test
//	public void testSetCpf() {
//		Person p1 = new Patient();
//
//		try {
//			p1.setCpf("249.021.251-61");
//		} catch (InvalidCpfException e) {
//			fail("CPF Invalido");
//		}
//
//		assert (p1.getCpf() == "24902125161");
//	}
//
//	@Test
//	public void testGetBirthDate() {
//		Person p1 = new Patient();
//
//		p1.setBirthDate(new Date("01/01/1990"));
//
//		assert (p1.getBirthDate() == new Date("01/01/1990"));
//	}
//
//	@Test
//	public void testSetBirthDate() {
//		Person p1 = new Patient();
//
//		p1.setBirthDate(new Date("01/01/1990"));
//
//		assert (p1.getBirthDate() == new Date("01/01/1990"));
//	}
//
//	@Test
//	public void testGetContacts() {
//		Person p1 = new Patient();
//
//		Contact c1 = new Contact();
//		c1.setContact("Contato");
//
//		Set<Contact> contactList = new HashSet<Contact>();
//		contactList.add(c1);
//
//		p1.setContacts(contactList);
//
//		assert (p1.getContacts().contains(c1));
//	}
//
//	@Test
//	public void testSetContacts() {
//		Person p1 = new Patient();
//
//		Contact c1 = new Contact();
//		c1.setContact("Contato");
//
//		Set<Contact> contactList = new HashSet<Contact>();
//		contactList.add(c1);
//
//		p1.setContacts(contactList);
//
//		assert (p1.getContacts().contains(c1));
//	}
//
//	@Test
//	public void testGetAddress() {
//		Person p1 = new Patient();
//
//		Address a1 = new Address();
//		a1.setStreet("Rua x");
//
//		p1.setAddress(a1);
//
//		assert (p1.getAddress().getStreet() == "Rua x");
//	}
//
//	@Test
//	public void testSetAddress() {
//		Person p1 = new Patient();
//
//		Address a1 = new Address();
//		a1.setStreet("Rua x");
//
//		p1.setAddress(a1);
//
//		assert (p1.getAddress().getStreet() == "Rua x");
//	}
//
//	@Test
//	public void testEqualsObject() {
//		Person p1 = new Patient();
//		Person p2 = new Patient();
//
//		p1.setId(1);
//		try {
//			p1.setCpf("249.021.251-61");
//		} catch (InvalidCpfException e) {
//			fail("CPF Invalido");
//		}
//
//		p2.setId(1);
//		try {
//			p2.setCpf("249.021.251-61");
//		} catch (InvalidCpfException e) {
//			fail("CPF Invalido");
//		}
//
//		assert (p1.equals(p2));
//	}

}
