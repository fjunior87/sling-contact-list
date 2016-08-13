package com.xicojunior.contacts.models;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author francisco.ribeiro
 *
 */
public class ContactList {

	private List<Contact> contacts = new ArrayList<Contact>();

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}

	@Override
	public String toString() {
		return "ContactList [contacts=" + contacts + "]";
	}
	
	
}
