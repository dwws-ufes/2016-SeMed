package br.ufes.inf.nemo.semed.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Drug extends PersistentObjectSupport implements Comparable<Drug> {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@Column(unique=true)
	private String referenceResource;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReferenceResource() {
		return referenceResource;
	}

	public void setReferenceResource(String referenceResource) {
		this.referenceResource = referenceResource;
	}

	@Override
	public int compareTo(Drug d) {
		if(d == null || d.getName()==null)	return 1;
		else if(this.getName() == null)		return -1;
		else return this.getName().compareTo(d.getName());
	}

}
