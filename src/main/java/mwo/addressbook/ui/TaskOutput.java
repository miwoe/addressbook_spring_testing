package mwo.addressbook.ui;

import java.util.Collection;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import mwo.addressbook.model.Address;
import mwo.addressbook.service.SearchAddress;
import mwo.addressbook.type.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskOutput {

	@Autowired
	SearchAddress searchAddress;
	
	public void performOutputs() {
		Collection<Address> femaleAddresses = searchAddress.getAllByGender(Gender.FEMALE);
		System.out.println("1.Female addresses: " + femaleAddresses.size());
		
		Vector<Address> sortedByAge = searchAddress.getAllSortByAge();
		System.out.println("2.Oldest person in addressbook: " + sortedByAge.firstElement().getFullName());
		
		Address bill = searchAddress.getOneByName("Bill McKnight");
		Address paul = searchAddress.getOneByName("Paul Robinson");
		long diff = paul.getBirthdate().getTime() - bill.getBirthdate().getTime();
	    System.out.println ("3.Bill is " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + " days older than Paul");
	}
}
