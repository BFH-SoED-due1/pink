package srsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import srs.Booker;
import srs.BookerAddress;
import srs.BookerName;

public class BookerTest {

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
		assertEquals(booker.getName(), newFirstName + " " + newLastName);
	}

	@Test
	public void testFirstName() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));
		
		assertEquals(booker.getFirstName(), firstName);
		booker.setFirstName(newFirstName);
		assertEquals(booker.getFirstName(), newFirstName);
	}
	
	public void testLastName() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(booker.getLastName(), lastName);
		booker.setLastName(newLastName);
		assertEquals(booker.getLastName(), newLastName);
	}
	
	//Address
	@Test
	public void testAddress() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(booker.getAddress(), country + " " + street + " " + streetNumber + " " + postcode + " " + village + " " + email);
		booker.setAddress(newCountry, newStreet, newStreetNumber, newPostcode, newVillage, newEmail);
		assertEquals(booker.getAddress(), newCountry + " " + newStreet + " " + newStreetNumber + " " + newPostcode + " " + newVillage + " " + newEmail);
	}
	
	@Test
	public void testCountry() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(booker.getCountry(), country);
		booker.setCountry(newCountry);
		assertEquals(booker.getCountry(), newCountry);
	}
	
	@Test
	public void testStreet() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(booker.getStreet(), street);
		booker.setStreet(newStreet);
		assertEquals(booker.getStreet(), newStreet);
	}
	
	@Test
	public void testStreetNumber() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(booker.getStreetNumber(), streetNumber);
		booker.setStreetNumber(newStreetNumber);
		assertEquals(booker.getStreetNumber(), newStreetNumber);
	}
	
	@Test
	public void testPostcode() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(booker.getPostcode(), postcode);
		booker.setPostcode(newPostcode);
		assertEquals(booker.getPostcode(), newPostcode);
	}
	
	@Test
	public void testVillage() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));
		
		assertEquals(booker.getVillage(), village);
		booker.setVillage(newVillage);
		assertEquals(booker.getVillage(), newVillage);
	}
	
	@Test
	public void testEmail() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		assertEquals(booker.getEmail(), email);
		booker.setEmail(newEmail);
		assertEquals(booker.getEmail(), newEmail);
	}
	
	@Test
	public void testDestrObj() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));

		booker = null;
		
		boolean thrown = false;
		try {
			assertEquals(booker.getName(), firstName + " " + lastName);
		} catch (NullPointerException e) {
		   thrown = true;
		}
		
	  assertTrue(thrown);
	}	
}
