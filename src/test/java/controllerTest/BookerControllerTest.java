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

import controller.implementation.BookerController;
import srs.Booker;
import srs.BookerAddress;
import srs.BookerName;

public class BookerControllerTest {
	Booker donald = new Booker(new BookerName("Donald", "Duck"),
			new BookerAddress("Disneyworld", "Hauptstrasse", "1", 1111, "Entenhausen", "donald@duck.com"));
	Booker mickey = new Booker(new BookerName("Mickey", "Mouse"),
			new BookerAddress("Mauseland", "Musterstrasse", "2", 1234, "Musterhausen", "mickey@mouse.com"));
	Booker bambi = new Booker(new BookerName("Bambi", "Bambini"),
			new BookerAddress("Disneyworld", "Aarbergstrasse", "3", 5678, "Rehhausen", "bambi@disney.com"));
	Booker balu = new Booker(new BookerName("Balu", "Bär"),
			new BookerAddress("Bärenland", "Hauptstrasse", "11", 1598, "Bärenhausen", "balu@disney.com"));

	@Test
	public void testIfBookerExists() {
		List<Booker> list = new ArrayList<Booker>();
		BookerController controller = new BookerController();

		list.add(donald);
		list.add(mickey);
		list.add(bambi);
		list.add(balu);

		assertTrue(controller.exists(list, donald.getEmail()));
	}

	@Test
	public void testSaveBookerOk() {
		List<Booker> list = new ArrayList<Booker>();
		BookerController controller = new BookerController();

		list.add(donald);
		list.add(mickey);
		list.add(bambi);

		assertEquals(3, list.size());
		controller.saveBooker(list, balu);
		assertEquals(4, list.size());

		assertTrue(list.get(list.size() - 1).getFirstName().equals(balu.getFirstName()));
	}

	@Test
	public void testDeleteBooker() {
		List<Booker> list = new ArrayList<Booker>();
		BookerController controller = new BookerController();

		list.add(donald);
		list.add(mickey);
		list.add(bambi);

		int size = list.size();
		assertEquals(3, size);

		Booker b = list.get(0).getBooker();
		assertEquals("Donald", b.getFirstName());
		controller.deleteBooker(list, b.getEmail()); // donald will be removed

		size = list.size();
		assertEquals(2, size);
	}

	@Test
	public void testEditBooker() {
		List<Booker> list = new ArrayList<Booker>();
		BookerController controller = new BookerController();

		list.add(donald);
		list.add(mickey);
		list.add(bambi);

		// to be continued....
		// assertTrue(controller.editBooker(list, bambi.getEmail()) instanceof Booker);
	}
}
