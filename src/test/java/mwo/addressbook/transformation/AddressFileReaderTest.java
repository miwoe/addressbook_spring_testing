package mwo.addressbook.transformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import mwo.addressbook.model.Address;
import mwo.addressbook.service.ImportAddress;
import mwo.addressbook.transformation.AddressFileReader;
import mwo.addressbook.transformation.AddressParseException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

public class AddressFileReaderTest {

	AddressFileReader addressFileReader;
	
	@Before
    public void init() {
        addressFileReader = new AddressFileReader();
    }
	
	@Test
	public void checkIfFileNotFoundWillBeThrownCorrectly() {
		try {
			Collection<Address> result = addressFileReader.readFromFile(new File("devnull.txt"));
			assertTrue(false);	
		} catch (IOException f) {
			assertTrue(true);
		} catch (AddressParseException e) {
			assertTrue(false);
		} 
	}
	
	
	
}
