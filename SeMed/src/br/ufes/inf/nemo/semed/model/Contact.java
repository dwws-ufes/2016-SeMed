package br.ufes.inf.nemo.semed.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String contact;
	private String contactChannel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactChannel() {
		return contactChannel;
	}

	public void setContactChannel(String contactChannel) {
		this.contactChannel = contactChannel;
	}

}
