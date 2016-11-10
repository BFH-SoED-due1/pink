/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import controller.implementation.BookerController;
import srs.Booker;

public class BookerControllerTest {
	Booker donald = new Booker("Donald", "Duck", "donald@duck.com");
	Booker mickey = new Booker("Mickey", "Mouse", "mickey@mouse.com");
	Booker bambi = new Booker("Bambi", "Bambini", "bambi@disney.com");
	Booker balu = new Booker("Balu", "Bär", "balu@disney.com");

	@Test
	public void testIfBookerExists() {
		List<Booker> list = new ArrayList<Booker>();
		BookerController controller = new BookerController();
		list.add(donald);
		list.add(mickey);
		list.add(bambi);
		list.add(balu);

		assertTrue(controller.exists(list, donald.getLogin()));
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
		controller.deleteBooker(list, b.getLogin()); // donald will be removed

		size = list.size();
		assertEquals(2, size);
	}

	@Test
	public void testEditBooker() {
		List<Booker> list = new ArrayList<Booker>();
		BookerController controller = new BookerController();
		list.add(donald);
		list.add(mickey);

		// lsödjkfklsdf
		// to be continued....
		// assertTrue(controller.editBooker(list, bambi.getEmail()) instanceof
		// Booker);
	}
}
