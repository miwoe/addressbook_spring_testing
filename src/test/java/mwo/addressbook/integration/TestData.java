package mwo.addressbook.integration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import mwo.addressbook.model.AddressesInMemory;

public class TestData extends AddressBookTestCase {
	
	@Autowired
	AddressesInMemory addresses;
	
	@Test
	public void testCorrectSizeOfTestData() {
		assertTrue(addresses.getAddressList().size() == 3);
	}

}
