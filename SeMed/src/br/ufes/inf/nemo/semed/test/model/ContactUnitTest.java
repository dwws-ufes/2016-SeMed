package br.ufes.inf.nemo.semed.test.model;

import org.junit.Test;

import br.ufes.inf.nemo.semed.model.Contact;

public class ContactUnitTest {

	@Test
	public final void testGetId() {
		Contact c1 = new Contact();

		c1.setId(1);

		assert (c1.getId() == 1);
	}

	@Test
	public final void testSetId() {
		Contact c1 = new Contact();

		c1.setId(1);

		assert (c1.getId() == 1);
	}

	@Test
	public final void testGetContact() {
		Contact c1 = new Contact();

		c1.setContact("teste");

		assert (c1.getContact() == "teste");
	}

	@Test
	public final void testSetContact() {
		Contact c1 = new Contact();

		c1.setContact("teste");

		assert (c1.getContact() == "teste");
	}

	@Test
	public final void testGetContactChannel() {
		Contact c1 = new Contact();

		c1.setContactChannel("teste");

		assert (c1.getContactChannel() == "teste");
	}

	@Test
	public final void testSetContactChannel() {
		Contact c1 = new Contact();

		c1.setContactChannel("teste");

		assert (c1.getContactChannel() == "teste");
	}

}
