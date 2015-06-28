package mwo.addressbook.transformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mwo.addressbook.model.Address;
import mwo.addressbook.type.Gender;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


public class StringAddressMapper {

	private SimpleDateFormat dateFormat;
	private String wordSeparator;
	
	/**
	 * @param dateFormat convenient dateFormat mapper
	 * @param wordSeparator 
	 */
	public StringAddressMapper(SimpleDateFormat dateFormat, String wordSeparator) {
		this.dateFormat = dateFormat;
		this.wordSeparator = wordSeparator;
	}
	
	public Address mapStringToAddress(String text) throws AddressParseException {
		String[] words = parseAddressParts(text);
		Address address = new Address();
		address.setFullName(parseName(words[0]));
		address.setGender(parseGender(words[1]));
		address.setBirthdate(parseBirthdate(words[2]));
		Logger.getLogger(this.getClass()).info("Map: " + address.getFullName());
		return address;
	}

	
	private String[] parseAddressParts(String text) throws AddressParseException {
		String[] words = text.split(wordSeparator);
		if (words.length != 3) throw new AddressParseException("Could not parse address part.");
		return words;
	}
	
	private String parseName(String name) {
		return name.trim();
	}
	
	private Gender parseGender(String gender) throws AddressParseException {
		try {
			Gender g = Gender.valueOf(gender.trim().toUpperCase());
			return g;
		} catch (IllegalArgumentException e) {
			throw new AddressParseException("Could not parse gender.");
		}
	}
	
	private Date parseBirthdate(String birthdate) throws AddressParseException {
		
		try {
			Date date = this.dateFormat.parse(birthdate.trim());
			if (this.dateFormat.format(date).equals(birthdate.trim())) {
				return date;
			}
			else {
				throw new AddressParseException(birthdate + " is not a valid date or malformed dd/mm/yy");
			}
			
		} catch (ParseException e) {
			throw new AddressParseException(birthdate + " is not a valid date");
		}
	}
}
