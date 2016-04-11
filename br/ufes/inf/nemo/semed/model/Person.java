/**
 * 
 */
package br.ufes.inf.nemo.semed.model;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufes.inf.nemo.semed.exception.InvalidCpfException;

/**
 * @author Guylerme Figueiredo
 *
 */
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String surname;
	private String cpf;

	@Temporal(TemporalType.DATE)
	private Date birthDate;
	private Set<Contact> contacts;
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws InvalidCpfException {
		if (this.validateCpf(cpf))
			this.cpf = cpf;
		else
			throw new InvalidCpfException();
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + (int) id;
		result = 31 * result + (cpf != null ? cpf.hashCode() : 0);

		return result;

	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;

		if (other == null || (this.getClass() != other.getClass())) {
			return false;
		}

		Person guest = (Person) other;
		return (this.id == guest.id)
				&& (this.cpf != null && cpf.equals(guest.cpf));
	}

	private boolean validateCpf(String cpf) {
		// Limpa pontos e traços
		cpf.replaceAll(".", "");
		cpf.replaceAll("-", "");

		if (cpf.equals("00000000000") || cpf.equals("11111111111")
				|| cpf.equals("22222222222") || cpf.equals("33333333333")
				|| cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777")
				|| cpf.equals("88888888888") || cpf.equals("99999999999")
				|| (cpf.length() != 11))
			return (false);
		char dig10, dig11;
		int sm, i, r, num, peso;
		// "try" - protege o codigo para eventuais erros de conversao de tipo
		// (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			// converte no respectivo caractere numerico
			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);
			// Verifica se os digitos calculados conferem com os digitos
			// informados.
			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

}
