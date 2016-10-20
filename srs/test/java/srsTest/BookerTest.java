package srsTest;

import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.Assert;
import srs.Booker;
import srs.BookerName;
import srs.BookerAddress;

public class BookerTest {
	
	@Test
	public void testNotNull() {
		BookerName name = new BookerName("Bob", "Marley");
		BookerAddress add = new BookerAddress("Jamaica", "Kingstonstreet", "1", 1123, "Kingston", "bob@marley.com");
		Booker b = new Booker(name, add);
		Assert.assertNotNull(b);
	}
	
	@Test
	public void testName() {
		BookerName name = new BookerName("Bob", "Marley");
		BookerAddress add = new BookerAddress("Jamaica", "Kingstonstreet", "1", 1123, "Kingston", "bob@marley.com");
		Booker b = new Booker(name, add);
		
		assertEquals(b.getFirstName(), "Bob");
		assertEquals(b.getLastName(), "Marley");
	}

	@Test
	public void testAddress() {
		BookerName name = new BookerName("Bob", "Marley");
		BookerAddress add = new BookerAddress("Jamaica", "Kingstonstreet", "1", 1123, "Kingston", "bob@marley.com");
		Booker b = new Booker(name, add);
		
		assertEquals(b.getStreet(), "Kingstonstreet");
		assertEquals(b.getStreetNumber(), "1");
		assertEquals(b.getPostcode(), 1123);
		assertEquals(b.getVillage(), "Kingston");
		assertEquals(b.getEmail(), "bob@marley.com");
	}

}
