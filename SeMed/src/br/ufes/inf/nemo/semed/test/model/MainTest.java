package br.ufes.inf.nemo.semed.test.model;

import br.ufes.inf.nemo.semed.exception.InvalidCpfException;
import br.ufes.inf.nemo.semed.model.Patient;
import br.ufes.inf.nemo.semed.model.Person;

public class MainTest {

	public static void main(String[] args) {
		Person p1 = new Patient();

		try {
			p1.setCpf("249.021.251-61");
		} catch (InvalidCpfException e) {
			System.out.println("CPF invalido");
		}

	}

}
