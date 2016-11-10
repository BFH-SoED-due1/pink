/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import controller.exceptions.BookerNotFoundException;
import controller.implementation.BookerController;
import srs.Booker;

public class BookerControllerTest {
	Booker donald = new Booker("Donald", "Duck", "donald@disney.com");
	Booker mickey = new Booker("Mickey", "Mouse", "mickey@disney.com");
	Booker bambi = new Booker("Bambi", "Bambini", "bambi@disney.com");
	Booker balu = new Booker("Balu", "Bär", "donald@disney.com");

	@Test
	public void testIfBookerExists() throws BookerNotFoundException {
		List<Booker> list = new ArrayList<Booker>();
		BookerController controller = new BookerController();
		list.add(donald);
		list.add(mickey);
		list.add(bambi);

		assertTrue(controller.exists(list, donald.getLogin()));
	}

	// (expected = BookerLoginException.class)
	@Test
	public void testSaveBooker() {
		List<Booker> list = new ArrayList<Booker>();
		BookerController controller = new BookerController();
		list.add(donald);
		list.add(mickey);
		assertEquals(2, list.size());

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		// controller.saveBooker(list, bambi);

		// controller.saveBooker(list, balu);
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
	public void testEditBooker() throws BookerNotFoundException {
		List<Booker> list = new ArrayList<Booker>();
		BookerController controller = new BookerController();
		list.add(donald);
		list.add(mickey);
		list.add(bambi);

		controller.editBooker(list, donald.getLogin(), balu.getFirstName(), balu.getLastName(), balu.getLogin());
		assertEquals(balu.getFirstName(), list.get(0).getFirstName());
		assertEquals(balu.getLastName(), list.get(0).getLastName());
		assertEquals(balu.getLogin(), list.get(0).getLogin());
	}
}
