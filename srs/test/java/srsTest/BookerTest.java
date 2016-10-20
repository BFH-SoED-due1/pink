package srsTest;

import static org.junit.Assert.*;
import org.junit.Test;

import srs.Booker;
import srs.Address;
import srs.BookerName;
import srs.BookerAddress;

public class BookerTest {

	private String firstName = "Hans";
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
	private String newstreet = "Seestrasse";
	private String newStreetNumber = "45";
	private int newPostcode = 1200;
	private String newVillage = "Genf";
	private String newEmail = "d@ha.ch";

	
	@Test
	public void testName() {
		Booker booker = new Booker(new BookerName(firstName, lastName), new BookerAddress(country, street, streetNumber, postcode, village, email));
		
		assertEquals(booker.getFirstName(), firstName);
		assertEquals(booker.getLastName(), lastName);
		
		booker.setName(newFirstName, newLastName);
		
		assertEquals(booker.getFirstName(), newFirstName);
		assertEquals(booker.getLastName(), newLastName);
	}
	
	
	
//	System.out.println("Booker Test \n\ntest getter: \nexpected name: " + name);
//	System.out.println("getName():      " + booker.getName());
//	System.out.println("----------------------------");
//
//	System.out.println("expected address: " + address);
//	System.out.println("getAddress():     " + booker.getAddress());
//	System.out.println("----------------------------");
//
//	System.out.println("expected mail: " + mail);
//	System.out.println("getMail():     " + booker.getMail());
//	System.out.println("\n----------------------------\n");
//
//	newName = "newName";
//	newAddress = "newAddress";
//	newMail = "newMail";
//
//	booker.setName(newName);
//	System.out.println("test setter: \nexpected name: " + newName);
//	System.out.println("getName():     " + booker.getName());
//	System.out.println("----------------------------");
//
//	booker.setAddress(newAddress);
//	System.out.println("expected address: " + newAddress);
//	System.out.println("getAddress():     " + booker.getAddress());
//	System.out.println("----------------------------");
//
//	booker.setMail(newMail);
//	System.out.println("expected mail: " + newMail);
//	System.out.println("getMail():     " + booker.getMail());
//	
//	assertEquals("NewMail", newMail);

}
