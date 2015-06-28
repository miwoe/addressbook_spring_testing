package mwo.addressbook.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mwo.addressbook.model.Address;
import mwo.addressbook.repository.AddressRepository;
import mwo.addressbook.transformation.AddressFileReader;
import mwo.addressbook.transformation.AddressParseException;
import mwo.addressbook.transformation.StringAddressMapper;

@Component
public class ImportAddress {


	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	AddressFileReader addressFileReader;
	
	public void importAddress(File file) throws IOException, AddressParseException {
		// Read from file
		Collection<Address> addresses = addressFileReader.readFromFile(file);
		// Save addresses to repository
		for (Address address : addresses) {
			addressRepository.save(address);
		}
		Logger.getLogger(this.getClass()).info("Imported " + addresses.size() + " addresses");
		Logger.getLogger(this.getClass()).info("Now " + addressRepository.getAll().size() + " addresses");
	}
	
}
