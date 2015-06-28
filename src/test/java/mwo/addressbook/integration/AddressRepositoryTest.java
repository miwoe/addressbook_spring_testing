package mwo.addressbook.integration;

import java.util.Date;

import mwo.addressbook.model.Address;
import mwo.addressbook.repository.AddressRepository;
import mwo.addressbook.type.Gender;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AddressRepositoryTest extends AddressBookTestCase {

	@Autowired
	AddressRepository addressRepository;
	
	
	@Test
	public void checkIfGetAllReturnsAllInititalData() {
		assertTrue(addressRepository.getAll().size() == 3);
	}
	
	@Test
	public void checkIfAnAddressCanBePersisted() {
		assertTrue(addressRepository.getAll().size() == 3);
		Address address = new Address();
		address.setBirthdate(new Date());
		address.setFullName("Baby Born");
		address.setGender(Gender.FEMALE);
		assertTrue(addressRepository.save(address));
		assertTrue(addressRepository.getAll().size() == 4);
	}
	
	@Test
	public void checkIfAnAddressCanBeDeleted() {
		assertTrue(addressRepository.getAll().size() == 3);
		Address toDelete = null;
		for (Address address : addressRepository.getAll()) {
			toDelete = address;
			break;
		}
		addressRepository.delete(toDelete);
		assertTrue(addressRepository.getAll().size() == 2);
	}
	
	@Test
	public void checkFindByGender() {
		assertTrue(addressRepository.getAll().size() == 3);
		assertTrue(addressRepository.findAllByGender(Gender.FEMALE).size() == 1);
		assertTrue(addressRepository.findAllByGender(Gender.MALE).size() == 2);
	}
	
	@Test
	public void checkFindByName() {
		assertTrue(addressRepository.findOneByName("Peter Parker") != null);
	}
	
	@Test
	public void checkFindByNotExistingNameReturnsNull() {
		assertTrue(addressRepository.findOneByName("foo") == null);
	}
	
}
