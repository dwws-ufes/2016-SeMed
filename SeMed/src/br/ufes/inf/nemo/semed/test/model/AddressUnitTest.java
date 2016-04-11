package br.ufes.inf.nemo.semed.test.model;

import org.junit.Test;

import br.ufes.inf.nemo.semed.model.Address;

public class AddressUnitTest {

	@Test
	public final void testGetId() {
		Address a1 = new Address();

		a1.setId(1);

		assert (a1.getId() == 1);
	}

	@Test
	public final void testSetId() {
		Address a1 = new Address();

		a1.setId(1);

		assert (a1.getId() == 1);
	}

	@Test
	public final void testGetStreet() {
		Address a1 = new Address();

		a1.setStreet("teste");

		assert (a1.getStreet() == "teste");
	}

	@Test
	public final void testSetStreet() {
		Address a1 = new Address();

		a1.setStreet("teste");

		assert (a1.getStreet() == "teste");
	}

	@Test
	public final void testGetNumber() {
		Address a1 = new Address();

		a1.setNumber(1);

		assert (a1.getNumber() == 1);
	}

	@Test
	public final void testSetNumber() {
		Address a1 = new Address();

		a1.setNumber(1);

		assert (a1.getNumber() == 1);
	}

	@Test
	public final void testGetDistrict() {
		Address a1 = new Address();

		a1.setDistrict("teste");

		assert (a1.getDistrict() == "teste");
	}

	@Test
	public final void testSetDistrict() {
		Address a1 = new Address();

		a1.setDistrict("teste");

		assert (a1.getDistrict() == "teste");
	}

	@Test
	public final void testGetCity() {
		Address a1 = new Address();

		a1.setCity("teste");

		assert (a1.getCity() == "teste");
	}

	@Test
	public final void testSetCity() {
		Address a1 = new Address();

		a1.setCity("teste");

		assert (a1.getCity() == "teste");
	}

	@Test
	public final void testGetState() {
		Address a1 = new Address();

		a1.setState("teste");

		assert (a1.getState() == "teste");
	}

	@Test
	public final void testSetState() {
		Address a1 = new Address();

		a1.setState("teste");

		assert (a1.getState() == "teste");
	}

	@Test
	public final void testGetZipCode() {
		Address a1 = new Address();

		a1.setZipCode("teste");

		assert (a1.getZipCode() == "teste");
	}

	@Test
	public final void testSetZipCode() {
		Address a1 = new Address();

		a1.setZipCode("teste");

		assert (a1.getZipCode() == "teste");
	}

}
