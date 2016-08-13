package com.xicojunior.contacts.adapter;

import java.util.Iterator;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.Resource;

import com.xicojunior.contacts.models.Contact;
import com.xicojunior.contacts.models.ContactList;

@Component
@Service
public class ContactListAdapterFactory implements AdapterFactory{

	@Property(name="adapters")
	public static final String[] ADAPTER_CLASSES = {
			ContactList.class.getName()
	};
	
	@Property(name="adaptables")
    public static final String[] ADAPTABLE_CLASSES = {
            SlingHttpServletRequest.class.getName()
	};
	
	public static String CONTACTS_NODE = "contacts";
	
	@Override
	@SuppressWarnings("unchecked")
	public <AdapterType> AdapterType getAdapter(Object adaptable, Class<AdapterType> type) {
		if(adaptable instanceof SlingHttpServletRequest
				&& type.equals(ContactList.class)) {
			
			ContactList contactList = new ContactList();
			SlingHttpServletRequest request = (SlingHttpServletRequest)adaptable;
			
			Resource appResource = request.getResource();
			Resource contactsNode = appResource.getChild(CONTACTS_NODE);
			Iterable<Resource> contacts = contactsNode.getChildren();
			Iterator<Resource> contactsIterator = contacts.iterator();
			while(contactsIterator.hasNext()) {
				contactList.addContact(contactsIterator.next().adaptTo(Contact.class));
			}
			
			return (AdapterType)contactList;
		}
		return null;
	}
	
}
