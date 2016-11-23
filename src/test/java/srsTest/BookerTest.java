/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package srsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import srs.Booker;
import srs.BookerAddress;
import srs.BookerName;

public class BookerTest {
	//Test booker, bookeraddress and bookername class
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


	//Name	@Test
	public void testName() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));
		assertEquals(booker.getName(), firstName + " " + lastName);
		booker.setName(newFirstName, newLastName);
		assertEquals(newFirstName + " " + newLastName, booker.getName());
	}

	@Test
	public void testFirstName() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));
		
		assertEquals(firstName, booker.getFirstName());
		booker.setFirstName(newFirstName);
		assertEquals(newFirstName, booker.getFirstName());
	}
	
	public void testLastName() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(lastName, booker.getLastName());
		booker.setLastName(newLastName);
		assertEquals(newLastName, booker.getLastName());
	}
	
	//Address
	@Test
	public void testAddress() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(country + " " + street + " " + streetNumber + " " + postcode + " " + village + " " + email, booker.getAddress());
		booker.setAddress(newCountry, newStreet, newStreetNumber, newPostcode, newVillage, newEmail);
		assertEquals(newCountry + " " + newStreet + " " + newStreetNumber + " " + newPostcode + " " + newVillage + " " + newEmail, booker.getAddress());
	}
	
	@Test
	public void testCountry() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(country, booker.getCountry());
		booker.setCountry(newCountry);
		assertEquals(newCountry, booker.getCountry());
	}
	
	@Test
	public void testStreet() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(street, booker.getStreet());
		booker.setStreet(newStreet);
		assertEquals(newStreet, booker.getStreet());
	}
	
	@Test
	public void testStreetNumber() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(streetNumber, booker.getStreetNumber());
		booker.setStreetNumber(newStreetNumber);
		assertEquals(newStreetNumber, booker.getStreetNumber());
	}
	
	@Test
	public void testPostcode() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(postcode, booker.getPostcode());
		booker.setPostcode(newPostcode);
		assertEquals(newPostcode, booker.getPostcode());
	}
	
	@Test
	public void testVillage() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));
		
		assertEquals(village, booker.getVillage());
		booker.setVillage(newVillage);
		assertEquals(newVillage, booker.getVillage());
	}
	
	@Test
	public void testEmail() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(email, booker.getEmail());
		booker.setEmail(newEmail);
		assertEquals(newEmail, booker.getEmail());
	}
	
	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testDestrObj() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		booker = null;

		assertEquals(firstName + " " + lastName, booker.getName());
	}	
}
