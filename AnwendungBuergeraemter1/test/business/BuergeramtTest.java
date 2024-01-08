package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuergeramtTest {
	
	private Buergeramt buergeramt;
	
	String[] test1 = {"Hauptwohnsitz","Nebenwohnsitz"};
	
	@BeforeEach
	void setUp() throws Exception {
		this.buergeramt = new Buergeramt("B�rgerb�ro Querenburg",
				9,17,"Querenburger H�he 256",test1);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.buergeramt = null;
	}

	@Test
	void test() {
		assertTrue(this.buergeramt.getName() == "B�rgerb�ro Querenburg");
	}
	
	
	/* Konstruktor B�rgeramt
	 * Name sei B�rgerb�ro Querenburg
	 * 9 bis 17 Uhr
	 * Querenburger H�he 256
	 * Dienstleistun null
	 * 
	 * IllegalArgumentException soll geworfen werden "Die vorgegebenen Dienstleistungen
	 * sind nicht korrekt."
	 * assertThrows -> Lambda Ausdruck und assertEquals
	 * wird nicht erfolgreich sein falsche Exception (NullPointerException)
	 * Sourcecode korrigieren
	 * test soll erfolgreich sein 
	 */

}
