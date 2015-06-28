package mwo.addressbook.transformation;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.expression.ParseException;

import mwo.addressbook.model.Address;
import mwo.addressbook.service.ImportAddress;
import mwo.addressbook.transformation.AddressParseException;
import mwo.addressbook.transformation.StringAddressMapper;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

public class StringAddressMapperTest {

	String ok = "Bill McKnight, Male, 16/03/77";
	String lessParts = "Bill McKnight, Male";
	String moreParts = "Bill McKnight, Male, 16/03/77,foo";
	String unparsableGender = "Bill McKnight, X, 16/03/77";
	String unparsableDate = "Bill McKnight, Male, 16/13/77";
	String unparsableDate2 = "Bill McKnight, Male, x16/11/77";
	
	StringAddressMapper stringAddressMapper;
	
	@Before
    public void init() {
		stringAddressMapper = new StringAddressMapper(new SimpleDateFormat("dd/MM/yy"), ",");
    }
	
	@Test
	public void lessPartsShouldThrowParseException() {
		try {
			stringAddressMapper.mapStringToAddress(lessParts);
			assertTrue(false);
		} catch (AddressParseException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void morePartsShouldThrowParseException() {
		try {
			stringAddressMapper.mapStringToAddress(moreParts);
			assertTrue(false);
		} catch (AddressParseException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void emptyTextShouldThrowParseException() {
		try {
			stringAddressMapper.mapStringToAddress("");
			assertTrue(false);
		} catch (AddressParseException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void unparsableGenderShouldThrowParseException() {
		try {
			stringAddressMapper.mapStringToAddress(unparsableGender);
			assertTrue(false);
		} catch (AddressParseException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void unparsableDateShouldThrowParseException() {
		try {
			stringAddressMapper.mapStringToAddress(unparsableDate);
			assertTrue(false);
		} catch (AddressParseException e) {
			assertTrue(true);
		}
	}
	@Test
	public void parsableAddress() throws AddressParseException {		
		stringAddressMapper.mapStringToAddress(ok);
		assertTrue(true);
	}
	
	
}
