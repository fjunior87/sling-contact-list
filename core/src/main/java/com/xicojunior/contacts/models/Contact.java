package com.xicojunior.contacts.models;
/**
 * 
 * Class that represents a Contact
 * @author francisco.ribeiro
 *
 */
public class Contact {

	private String name;
	private String email;
	private String phone;
	private String address;
	private String contactImage;

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactImage() {
		return contactImage;
	}
	public void setContactImage(String contactImage) {
		this.contactImage = contactImage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Contact [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", contactImage=" + contactImage + "]";
	}
	
}
