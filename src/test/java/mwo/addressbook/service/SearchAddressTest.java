package mwo.addressbook.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import mwo.addressbook.model.Address;
import mwo.addressbook.repository.AddressRepository;
import mwo.addressbook.service.SearchAddress;
import mwo.addressbook.transformation.AddressFileReader;
import mwo.addressbook.type.Gender;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SearchAddressTest {

	SearchAddress searchAddress;
	
	@Test
	public void checkSortByAge() {
		Vector<Address> resultList = searchAddress.getAllSortByAge();
		Long before = 0l;
		for (Address address : resultList) {
			assertTrue(address.getBirthdate().getTime() > before);
			before = address.getBirthdate().getTime();
		}
	}
	
	
	@Before
    public void init() {
		searchAddress = new SearchAddress();
		searchAddress.addressRepository = mock(AddressRepository.class);
		ArrayList<Address> addresses = new ArrayList<Address>();
		Address address = new Address();
		address.setBirthdate(new Date(1435437962293l));
		address.setFullName("3");
		address.setGender(Gender.FEMALE);
		Address address2 = new Address();
		address2.setBirthdate(new Date(1435427962293l));
		address2.setFullName("2");
		address2.setGender(Gender.MALE);
		Address address3 = new Address();
		address3.setBirthdate(new Date(1435417962293l));
		address3.setFullName("1");
		address3.setGender(Gender.FEMALE);
		Address address4 = new Address();
		address4.setBirthdate(new Date(1435447962293l));
		address4.setFullName("4");
		address4.setGender(Gender.MALE);
		addresses.add(address);
		addresses.add(address2);
		addresses.add(address3);
		addresses.add(address4);
		when(searchAddress.addressRepository.getAll()).thenReturn(addresses);
    }
}
