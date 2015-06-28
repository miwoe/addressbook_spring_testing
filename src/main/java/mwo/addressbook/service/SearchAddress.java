package mwo.addressbook.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import mwo.addressbook.model.Address;
import mwo.addressbook.repository.AddressRepository;
import mwo.addressbook.type.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchAddress {

	@Autowired
	AddressRepository addressRepository;
	
	
	public Vector<Address> getAllSortByAge() {
		Vector<Address> allAddresses = new Vector<Address>();
		allAddresses.addAll(addressRepository.getAll());
		Collections.sort(allAddresses, new Comparator<Address>() {
			public int compare(Address from, Address to) {
				return from.getBirthdate().compareTo(to.getBirthdate());
			}
		});
		return allAddresses;
	}
	
	public Collection<Address> getAllByGender(Gender gender) {
		return addressRepository.findAllByGender(gender);
	}
	
	public Address getOneByName(String name) {
		return addressRepository.findOneByName(name);
	}

}
