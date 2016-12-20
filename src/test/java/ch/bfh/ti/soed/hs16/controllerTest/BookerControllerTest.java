/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.controller.BookerController;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.BookerLoginException;
import ch.bfh.ti.soed.hs16.srs.model.Booker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;

public class BookerControllerTest {
	private BookerController bookerController;

	@Before
	public void setUp() {
		this.bookerController = new BookerController();
	}

	@Test
	public void saveBookerTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans1@muster.ch";

		this.bookerController.saveBooker(firstName, lastName, email);

		List<IBooker> bookers = this.bookerController.listAllBookers();
		IBooker b = this.bookerController.getBookerByEmail(email);

		assertTrue(bookers.contains(b));
	}

	@Test(expected = BookerLoginException.class)
	public void saveBookerTwiceTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans2@muster.ch";

		this.bookerController.saveBooker(firstName, lastName, email);
		this.bookerController.saveBooker(firstName, lastName, email);
	}

	@Test(expected = IllegalArgumentException.class)
	public void saveEmptyBookerTest() {
		String firstName = "";
		String lastName = "";
		String email = "";

		this.bookerController.saveBooker(firstName, lastName, email);
	}

	@Test
	public void deleteBookerTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans3@muster.ch";

		this.bookerController.saveBooker(firstName, lastName, email);

		IBooker b = this.bookerController.getBookerByEmail(email);

		this.bookerController.deleteBooker(b);

		List<IBooker> bookers = this.bookerController.listAllBookers();

		assertFalse(bookers.contains(b));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteNotExistingBookerTest() {
		IBooker donald = new Booker("Donald", "Duck", "donald@duck.com");

		this.bookerController.deleteBooker(donald);
	}

	@Test
	public void editBookerTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans4@muster.ch";

		this.bookerController.saveBooker(firstName, lastName, email);

		IBooker b = this.bookerController.getBookerByEmail(email);
		String newFname = "Hansi";
		String newLname = "Musti";

		this.bookerController.editBooker(newFname, newLname, b);

		assertEquals(newFname, b.getFirstName());
		assertEquals(newLname, b.getLastName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void editWrongBookerTest() {
		IBooker b = new Booker("Dagobert", "Duck", "dagobert@duck.ch");

		this.bookerController.editBooker("Dagi", "Duck", b);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getWrongBookerByNameTest() {
		this.bookerController.getBookerByEmail("du@hast.ch");
	}

	@Test(expected = IllegalArgumentException.class)
	public void editEmptyBookerTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans5@muster.ch";

		this.bookerController.saveBooker(firstName, lastName, email);

		IBooker b = this.bookerController.getBookerByEmail(email);

		this.bookerController.editBooker("", "", b);
	}
}
