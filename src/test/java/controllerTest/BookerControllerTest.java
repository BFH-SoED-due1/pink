/**Copyright(c)2016 Berner Fachhochschule,Switzerland.
 * *Project Smart Reservation System.
 * *Distributable under GPL license.See terms of license at gnu.org.*/
package controllerTest;

import org.junit.Before;
import org.junit.Test;

import jpa.Booker;
import service.implementation.BookerController;

public class BookerControllerTest {
	private BookerController bookerController;

	@Before
	public void setUp() {
		this.bookerController = new BookerController();
	}

	// @Test
	// public void saveBookerTest() {
	// Booker booker = bookerController.saveBooker("Donald", "Duck",
	// "donald@duckius.com");
	// List<Booker> list = bookerController.getAllBookers();
	// assertTrue(list.contains(booker));
	// }

	// @Test(expected = BookerLoginException.class)
	// public void saveBookerTwiceTest() {
	// Booker booker = bookerController.saveBooker("Donald", "Duck",
	// "donald@duck1.com");
	// Booker booker1 = bookerController.saveBooker("Donald", "Duck",
	// "donald@duck1.com");
	//
	// }
	//
	// @Test(expected = IllegalArgumentException.class)
	// public void saveEmptyBookerTest() {
	// Booker booker = bookerController.saveBooker("", "", "");
	// }

	// @Test
	// public void deleteBookerTest() {
	// Booker booker = bookerController.saveBooker("Donald", "Duck",
	// "donald@duckis2.com");
	// bookerController.deleteBooker(booker);
	// List<Booker> list = bookerController.getAllBookers();
	// assertFalse(list.contains(booker));
	// }

	@Test(expected = IllegalArgumentException.class)
	public void deleteNotExistingBookerTest() {
		Booker booker = new Booker("Donald", "Duck", "donald@duck3.com");

		bookerController.deleteBooker(booker);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteEmptyBookerTest() {
		Booker booker = new Booker("", "", "");

		bookerController.deleteBooker(booker);
	}

	// @Test
	// public void editBookerTest() { // TODO
	// Booker booker = bookerController.saveBooker("Donald", "Duck",
	// "asdf@ddd.com");
	//
	// String newFirstName = "Mickey";
	// String newLastName = "Mouse";
	//
	// bookerController.editBooker(newFirstName, newLastName, booker);
	//
	// assertEquals(newFirstName, booker.getFirstName());
	// assertEquals(newLastName, booker.getLastName());
	// }

	@Test(expected = IllegalArgumentException.class)
	public void editWrongBookerTest() {
		Booker booker = bookerController.saveBooker("Donald", "Duck", "donald@duck5.com");
		Booker mickey = new Booker("Mickey", "Mouse", "mickey@mouse.com");

		bookerController.editBooker("Mini", "Mouse", mickey);
	}

	@Test(expected = IllegalArgumentException.class)
	public void editEmptyBookerTest() {
		Booker booker = bookerController.saveBooker("Donald", "Duck", "donald@duck6.com");

		bookerController.editBooker("", "", booker);
	}
}
