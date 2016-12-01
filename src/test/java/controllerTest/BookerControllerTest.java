/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import control.ABooker;
import control.BookerController;
import control.exceptions.BookerLoginException;
import model.Booker;

public class BookerControllerTest {

	@Test
	public void saveBookerTest() {
		ABooker donald = new Booker("Donald", "Duck", "donald@duck.com");
		List<ABooker> list = new ArrayList<ABooker>();
		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		assertTrue(list.contains(donald));
	}

	@Test(expected = BookerLoginException.class)
	public void saveBookerTwiceTest() {
		ABooker donald = new Booker("Donald", "Duck", "donald@duck.com");
		List<ABooker> list = new ArrayList<ABooker>();
		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		list = bc.saveBooker(donald);
	}

	@Test(expected = IllegalArgumentException.class)
	public void saveEmptyBookerTest() {
		Booker donald = new Booker("", "", "");
		List<ABooker> list = new ArrayList<ABooker>();
		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
	}

	@Test
	public void deleteBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");

		List<ABooker> list = new ArrayList<ABooker>();
		List<Booker> expectedList = new ArrayList<Booker>();
		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		expectedList.add(donald);

		list = bc.deleteBooker(donald.getLogin());
		expectedList.remove(donald);

		assertEquals(expectedList, list);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteNotExistingBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");
		Booker mickey = new Booker("Mickey", "Mouse", "mickey@mouse.com");

		List<ABooker> list = new ArrayList<ABooker>();
		List<ABooker> expectedList = new ArrayList<ABooker>();

		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		expectedList.add(donald);

		list = bc.deleteBooker(mickey.getLogin());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteEmptyBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");
		Booker mickey = new Booker("", "", "");

		List<ABooker> list = new ArrayList<ABooker>();
		List<ABooker> expectedList = new ArrayList<ABooker>();
		BookerController bc = new BookerController(list);

		list = bc.saveBooker(donald);
		expectedList.add(donald);

		list = bc.deleteBooker(mickey.getLogin());
	}

	@Test
	public void editBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");
		Booker donald1 = new Booker("Donald", "Duck", "donald@duck1.com");

		List<ABooker> list = new ArrayList<ABooker>();
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

		List<ABooker> list = new ArrayList<ABooker>();
		BookerController bc = new BookerController(list);
		list = bc.saveBooker(donald);

		bc.editBooker("Mickey", "Mausius", mickey);
	}

	@Test(expected = IllegalArgumentException.class)
	public void editEmptyBookerTest() {
		Booker donald = new Booker("Donald", "Duck", "donald@duck.com");

		List<ABooker> list = new ArrayList<ABooker>();
		BookerController bc = new BookerController(list);
		list = bc.saveBooker(donald);

		bc.editBooker("", "", donald);
	}
}
