package mwo.addressbook.integration;

import java.util.ArrayList;
import java.util.Collection;

import mwo.addressbook.model.Address;
import mwo.addressbook.repository.AddressRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-test-configuration.xml"})
public abstract class AddressBookTestCase extends TestCase {

	@Autowired
	AddressRepository addressRepository;
	
	Collection<Address> addresses;
	
	@Before
	public void prepareTest() {
		addresses = addressRepository.getAll();
	}
	
	@After
	public void cleanUp() {
		for (Address address : addressRepository.getAll()) {
			if (!addresses.contains(address)) {
				addressRepository.delete(address);
			}
		}
		for (Address address : addresses) {
			if (!addressRepository.getAll().contains(address)) {
				addressRepository.save(address);
			}
		}
	}
}
