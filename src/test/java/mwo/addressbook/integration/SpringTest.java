package mwo.addressbook.integration;

import org.junit.Test;

/**
 * Testet die Spring-Configuration und die Testdatenkorrektheit
 * @author Grauschleier
 *
 */
public class SpringTest extends AddressBookTestCase {

	@Test
    public void testAppBootstrap()
    {
		/**
		 * Wenn ein Test gestartet wird, muss die Springkonfiguration zur Verfügung stehen (impliziter Test).
		 * Spring wirft Fehler, wenn Konfigurationsdatei unlesbar oder fehlerhaft ist.
		 */
		assertTrue(true);
    }
}
