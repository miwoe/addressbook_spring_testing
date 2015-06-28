package mwo.addressbook.ui;

import java.io.File;
import java.io.IOException;

import mwo.addressbook.service.ImportAddress;
import mwo.addressbook.transformation.AddressParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskImport {

	
	@Autowired
	ImportAddress importAddress;
	
	public void importAddresses(File file) {
		try {
			importAddress.importAddress(file);
		} catch (IOException e) {
			System.out.println("Die Datei konnte nicht gefunden werden.");
			e.printStackTrace();
			System.exit(0);
		} catch (AddressParseException e) {
			System.out.println("Die Datei konnte nicht gelesen werden.");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
