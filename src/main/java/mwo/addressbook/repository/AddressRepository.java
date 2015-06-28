package mwo.addressbook.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mwo.addressbook.model.Address;
import mwo.addressbook.model.AddressesInMemory;
import mwo.addressbook.type.Gender;

/**
 * The repository is realized as an InMemory repository
 * @author Michael Wölm
 *
 */
@Component
public class AddressRepository {

	@Autowired
	private AddressesInMemory addressesInMemory;
	
	public Collection<Address> getAll() {
		Collection<Address> addresses = new ArrayList<Address>();
		addresses.addAll(addressesInMemory.getAddressList());
		return addresses;
	}
	
	public boolean save(Address address) {
		return addressesInMemory.getAddressList().add(address);
	}
	
	public boolean delete(Address address) {
		return addressesInMemory.getAddressList().remove(address);
	}
	
	public Collection<Address> findAllByGender(Gender gender) {
		Collection<Address> resultList = new ArrayList<Address>();
		for (Address address : addressesInMemory.getAddressList()) {
			if (address.getGender().equals(gender)) resultList.add(address);
		}
		return resultList;
	}
	
	public Address findOneByName(String name) {
		for (Address address : addressesInMemory.getAddressList()) {
			if (address.getFullName().equals(name)) return address;
		}
		return null;
	}
}
