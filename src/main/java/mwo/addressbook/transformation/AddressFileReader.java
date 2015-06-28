package mwo.addressbook.transformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mwo.addressbook.model.Address;

@Component
public class AddressFileReader {
	@Autowired
	StringAddressMapper stringAddressMapper;
	
	public Collection<Address> readFromFile(File file) throws IOException, AddressParseException {
		if (!file.exists()) throw new FileNotFoundException(file.getAbsolutePath());
		
		return readFromBuffer(new FileReader(file));
	}
	
	public Collection<Address> readFromBuffer(FileReader fileReader) throws IOException, AddressParseException {
		BufferedReader br = new BufferedReader(fileReader); 
		Collection<Address> addresses = new ArrayList<Address>();
		int lineCounter = 1;
		for(String line; (line = br.readLine()) != null; lineCounter++) {
	        try {
				addresses.add(stringAddressMapper.mapStringToAddress(line));
			} catch (AddressParseException e) {
				Logger.getLogger(this.getClass()).fatal("At line " + lineCounter + ": " + e.getMessage());
				throw e;
			}
	    }
		return addresses;
	}
}
