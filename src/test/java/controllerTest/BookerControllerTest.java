/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import controller.exceptions.BookerLoginException;
import controller.implementation.BookerController;
import srs.Booker;

public class BookerControllerTest {
	// Booker donald = new Booker("Donald", "Duck", "donald@duck.com");
	// Booker mickey = new Booker("Mickey", "Mouse", "mickey@mouse.com");
	// Booker bambi = new Booker("Bambi", "Bambini", "bambi@disney.com");
	// Booker balu = new Booker("Balu", "Bär", "balu@disney.com");

	@Test
	public void saveBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");

		List<Booker> list = new ArrayList<Booker>();
		List<Booker> oldList = new ArrayList<Booker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		oldList.add(donald);

		assertEquals(oldList, list);
	}

	@Test(expected = BookerLoginException.class)
	public void saveBookerTwiceTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");

		List<Booker> list = new ArrayList<Booker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		list = bc.saveBooker(donald);
	}

	@Test(expected = IllegalArgumentException.class)
	public void saveEmptyBookerTest() {
		Booker donald = new Booker("", "", "");

		List<Booker> list = new ArrayList<Booker>();
		List<Booker> oldList = new ArrayList<Booker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		oldList.add(donald);

		assertEquals(oldList, list);
	}

	@Test
	public void deleteBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");

		List<Booker> list = new ArrayList<Booker>();
		List<Booker> oldList = new ArrayList<Booker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		oldList.add(donald);

		list = bc.deleteBooker(donald.getLogin());
		oldList.remove(donald);

		assertEquals(oldList, list);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteNotExistingBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");
		Booker mickey = new Booker("Mickey", "Mouse", "mickey@mouse.com");

		List<Booker> list = new ArrayList<Booker>();
		List<Booker> oldList = new ArrayList<Booker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		oldList.add(donald);

		list = bc.deleteBooker(mickey.getLogin());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteEmptyBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");
		Booker mickey = new Booker("", "", "");

		List<Booker> list = new ArrayList<Booker>();
		List<Booker> oldList = new ArrayList<Booker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		oldList.add(donald);

		list = bc.deleteBooker(mickey.getLogin());
	}

	@Test
	public void editBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");
		Booker donald1 = new Booker("Donald", "Duck", "donald@duck1.com");

		List<Booker> list = new ArrayList<Booker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);

		bc.editBooker("Donaldius", "Duckius", donald);
		donald1.setFirstName("Donaldius");
		donald1.setLastName("Duckius");

		assertEquals(donald1.getFirstName(), donald.getFirstName());
		assertEquals(donald1.getLastName(), donald.getLastName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void editWrongBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");
		Booker mickey = new Booker("Mickey", "Mouse", "mickey@mouse.com");

		List<Booker> list = new ArrayList<Booker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);

		bc.editBooker("Mickey", "Mausius", mickey);
	}

	@Test(expected = IllegalArgumentException.class)
	public void editEmptyBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");

		List<Booker> list = new ArrayList<Booker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);

		bc.editBooker("", "", donald);
	}
}
