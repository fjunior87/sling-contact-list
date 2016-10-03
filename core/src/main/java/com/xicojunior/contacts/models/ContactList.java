package com.xicojunior.contacts.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

/**
 * 
 * @author francisco.ribeiro
 *
 */
@Model(adaptables=SlingHttpServletRequest.class)
public class ContactList {

	@Inject @Via("resource")
	private List<Contact> contacts;

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}

	@PostConstruct
	public void init() {
		System.out.println("Contacts:" + this.contacts);
	}
	
	@Override
	public String toString() {
		return "ContactList [contacts=" + contacts + "]";
	}
	
	
}
