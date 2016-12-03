/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package srsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Booker;
import model.IBooker;

public class BookerTest {
	/** Test classes booker, bookerName */
	private final String firstName = "Hans";
	private String lastName = "Muster";
	private String email = "hans@muster.ch";

	private String newFirstName = "Fritz";
	private String newLastName = "Meier";
	private String newEmail = "fritz@meier.ch";

	// Name
	@Test
	public void testOverridenToString() {
		IBooker booker = new Booker(firstName, lastName, email);
		assertEquals(booker.toString(), firstName + " " + lastName + " " + email);
	}

	@Test
	public void testFirstName() {
		IBooker booker = new Booker(firstName, lastName, email);

		assertEquals(firstName, booker.getFirstName());
		booker.setFirstName(newFirstName);
		assertEquals(newFirstName, booker.getFirstName());
	}

	public void testLastName() {
		IBooker booker = new Booker(firstName, lastName, email);

		assertEquals(lastName, booker.getLastName());
		booker.setLastName(newLastName);
		assertEquals(newLastName, booker.getLastName());
	}

	@Test
	public void testEmail() {
		IBooker booker = new Booker(firstName, lastName, email);

		assertEquals(email, booker.getLogin());
		booker.setLogin(newEmail);
		assertEquals(newEmail, booker.getLogin());
	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testDestrObj() {
		IBooker booker = new Booker(firstName, lastName, email);

		booker = null;

		assertEquals(firstName + " " + lastName, booker.toString());
	}

	@Test
	public void testReturnValueBookerObject() {
		IBooker booker = new Booker(firstName, lastName, email);
		assertTrue(booker.getBooker() instanceof Booker);
	}
}
