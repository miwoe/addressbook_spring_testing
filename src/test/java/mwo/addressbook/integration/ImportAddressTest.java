package mwo.addressbook.integration;

import java.io.File;
import java.io.IOException;

import mwo.addressbook.model.Address;
import mwo.addressbook.repository.AddressRepository;
import mwo.addressbook.service.ImportAddress;
import mwo.addressbook.transformation.AddressParseException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportAddressTest extends AddressBookTestCase {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired 
	ImportAddress importAddress;
	
	@Test 
	public void checkCorrectReading() throws IOException, AddressParseException {
		Logger.getLogger(getClass()).info(addressRepository.getAll().size());
		assertTrue(addressRepository.getAll().size() == 3);
		File addressFile = new File("addresses.csv");
		importAddress.importAddress(addressFile);
		for(Address address : addressRepository.getAll()) {
			Logger.getLogger(this.getClass()).debug(address.getFullName());
		}
		assertTrue(addressRepository.getAll().size() == 8);
	}
}
