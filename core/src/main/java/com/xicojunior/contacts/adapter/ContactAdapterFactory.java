package com.xicojunior.contacts.adapter;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;

import com.xicojunior.contacts.models.Contact;
@Component
@Service
@Properties({
	@Property(name=AdapterFactory.ADAPTABLE_CLASSES, value="org.apache.sling.api.resource.Resource"),
	@Property(name=AdapterFactory.ADAPTER_CLASSES, value="com.xicojunior.contacts.models.Contact")
})
public class ContactAdapterFactory implements AdapterFactory{

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
			
			return (AdapterType)contact;
		} else {
			return null;
		}
	}
	
}
