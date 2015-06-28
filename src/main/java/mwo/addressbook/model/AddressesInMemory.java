package mwo.addressbook.model;

import java.util.ArrayList;
import java.util.Collection;


public class AddressesInMemory {

	private Collection<Address> addressList = new ArrayList<Address>();

	public Collection<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(Collection<Address> addressList) {
		this.addressList = addressList;
	}
	
	
}
