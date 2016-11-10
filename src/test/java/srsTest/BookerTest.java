/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package srsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import srs.Booker;

public class BookerTest {
	/** Test classes booker, bookerName */
	private final String firstName = "Hans";
	private String lastName = "Muster";
	private String country = "Switzerland";
	private String street = "Bernstrasse";
	private String streetNumber = "27A";
	private int postcode = 3000;
	private String village = "Bern";
	private String email = "d@h.ch";

	private String newFirstName = "Fritz";
	private String newLastName = "Meier";
	private String newCountry = "Switzerland";
	private String newStreet = "Seestrasse";
	private String newStreetNumber = "45";
	private int newPostcode = 1200;
	private String newVillage = "Genf";
	private String newEmail = "d@ha.ch";

	// Name
	@Test
	public void testBookerInfo() {
		Booker booker = new Booker(firstName, lastName, email);
		assertEquals(booker.getBookerInfo(), firstName + " " + lastName + " " + email);
		booker.setBookerInfo(newFirstName, newLastName, email);
		assertEquals(newFirstName + " " + newLastName, booker.getBookerInfo());
	}

	@Test
	public void testFirstName() {
		Booker booker = new Booker(firstName, lastName, email);

		assertEquals(firstName, booker.getFirstName());
		booker.setFirstName(newFirstName);
		assertEquals(newFirstName, booker.getFirstName());
	}

	public void testLastName() {
		Booker booker = new Booker(firstName, lastName, email);

		assertEquals(lastName, booker.getLastName());
		booker.setLastName(newLastName);
		assertEquals(newLastName, booker.getLastName());
	}

	@Test
	public void testEmail() {
		Booker booker = new Booker(firstName, lastName, email);

		assertEquals(email, booker.getLogin());
		booker.setLogin(newEmail);
		assertEquals(newEmail, booker.getLogin());
	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testDestrObj() {
		Booker booker = new Booker(firstName, lastName, email);

		booker = null;

		assertEquals(firstName + " " + lastName, booker.getBookerInfo());
	}

	@Test
	public void testReturnValueBookerObject() {
		Booker booker = new Booker(firstName, lastName, email);
		assertTrue(booker.getBooker() instanceof Booker);
	}
}
