package com.xicojunior.contacts.adapter;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;

import com.xicojunior.contacts.models.Contact;

/**
 * 
 * @author francisco.ribeiro
 * 
 * AdapterFactory implementation intended to Adpat Resource instances to
 * Contact instances.
 * 
 */
@Component
@Service
public class ContactAdapterFactory implements AdapterFactory{
	
	@Property(name="adapters")
	public static final String[] ADAPTER_CLASSES = {
			Contact.class.getName()
	};
	
	@Property(name="adaptables")
    public static final String[] ADAPTABLE_CLASSES = {
            Resource.class.getName()
	};
	

	@Override
	@SuppressWarnings("unchecked")
	public <AdapterType> AdapterType getAdapter(Object adaptable, Class<AdapterType> type) {
		if(adaptable instanceof Resource &&
				type.equals(Contact.class)) {
			Contact contact = new Contact();
			Resource resource = (Resource)adaptable;
			ValueMap valueMap = ResourceUtil.getValueMap((Resource)adaptable);
			contact.setName(valueMap.get("name", String.class));
			contact.setEmail(valueMap.get("email", String.class));
			contact.setPhone(valueMap.get("phone", String.class));
			contact.setAddress(valueMap.get("address", String.class));
			
			Resource contactImage = resource.getChild("contactImage");
			
			if(contactImage != null) {
				contact.setContactImage(contactImage.getPath());
			}
			System.out.println(contact);
			return (AdapterType)contact;
		} else {
			return null;
		}
	}
	
}
