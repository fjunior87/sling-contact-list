package com.xicojunior.contacts.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

/**
 * 
 * Class that represents a Contact
 * @author francisco.ribeiro
 *
 */
@Model(adaptables=org.apache.sling.api.resource.Resource.class)
public class Contact {

	@Inject
	private String name;
	
	@Inject
	private String email;
	
	@Inject
	private String phone;
	
	@Inject
	private String address;
	
	@ChildResource @Named("contactImage")
	private Resource contactImageResource;
	
	private String contactImage;

	@PostConstruct
	public void init() {
		this.contactImage = contactImageResource.getPath();
	}
	
	
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
