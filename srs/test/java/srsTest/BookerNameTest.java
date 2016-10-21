package srsTest;
//a
import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.Assert;
import srs.BookerName;

public class BookerNameTest {

	@Test
	public void testFirstName() {
		BookerName name = new BookerName("Donald", "Duck");
		assertEquals(name.getFirstName(), "Donald");
	}
	
	@Test
	public void testLastName() {
		BookerName name = new BookerName("Donald", "Duck");
		Assert.assertEquals(name.getLastName(), "Duck");
	}

	@Test
	public void testTwoNamesNotEqual() {
		BookerName name1 = new BookerName("Donald", "Duck");
		BookerName name2 = new BookerName("Mickey", "Mouse");
		assertEquals(name1.getFirstName(), "Donald");
		assertEquals(name2.getFirstName(), "Mickey");
		
		Assert.assertFalse(name1.getFirstName().equals(name2.getFirstName()));
	}

}
