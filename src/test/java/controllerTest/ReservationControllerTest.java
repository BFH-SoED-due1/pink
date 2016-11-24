/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import jpa.Booker;
import jpa.Reservation;
import jpa.Room;
import service.implementation.ReservationController;
import service.implementation.exceptions.ReservationException;
import service.implementation.exceptions.ReservationNotFoundException;

@SuppressWarnings("deprecation")
public class ReservationControllerTest {

	String fNameDonald = "Donald";
	String lNameDonald = "Duck";
	String emailDonald = "donald@disney.com";

	String fNameMicky = "Micky";
	String lNameMicky = "Mouse";
	String emailMicky = "micky@mouse.com";

	Booker donald = new Booker(fNameDonald, lNameDonald, emailDonald);
	Booker micky = new Booker(fNameDonald, lNameMicky, emailMicky);

	Date d1 = new Date(2016, 11, 11);
	Time from1 = new Time(8, 00, 00);
	Time to1 = new Time(17, 00, 00);
	Date d2 = new Date(2016, 11, 10);
	Time from2 = new Time(9, 00, 00);
	Time to2 = new Time(18, 00, 00);

	Room r1 = new Room(100, "Room 1", "Beamer, Seats, Computer");
	Room r2 = new Room(200, "Room 2", "Beamer, Seats, Computer, TV");
	Room r3 = new Room(10, "Pause 1", "Coffeemashine, Sandwich");
	Room r4 = new Room(20, "Pause 2", "Coffeemashine, Sandwich");

	@Test
	public void testReservateNormal() {
		List<Reservation> list = new ArrayList<Reservation>();
		ReservationController ctrl = new ReservationController(list);
		list = ctrl.reservate(donald, d1, from1, to1, r1);
		list = ctrl.reservate(donald, d2, from1, to1, r2);

		List<Reservation> temp = new ArrayList<Reservation>();
		temp = list;

		assertEquals(list, temp);
	}

	@Test(expected = ReservationException.class)
	public void testReservateExpectException() {
		List<Reservation> list = new ArrayList<Reservation>();
		ReservationController ctrl = new ReservationController(list);
		list = ctrl.reservate(donald, d1, from1, to1, r1);
		list = ctrl.reservate(micky, d1, from1, to1, r1);
	}

	@Test
	public void testCancel() throws ReservationNotFoundException {
		List<Reservation> list = new ArrayList<Reservation>();
		ReservationController ctrl = new ReservationController(list);
		list = ctrl.reservate(donald, d1, from1, to1, r1);
		list = ctrl.reservate(donald, d2, from1, to1, r2);

		List<Reservation> temp = new ArrayList<Reservation>();
		temp = list;

		assertEquals(list, temp);
		assertEquals(list.size(), 2);

		list = ctrl.cancel(donald, d1, from1, to1, r1);
		temp = list;

		assertEquals(list, temp);
		assertEquals(list.size(), 1);
	}

	@Test(expected = ReservationNotFoundException.class)
	public void testCancelThrowException() throws ReservationNotFoundException {
		List<Reservation> list = new ArrayList<Reservation>();
		ReservationController ctrl = new ReservationController(list);
		list = ctrl.reservate(donald, d1, from1, to1, r1);

		List<Reservation> temp = new ArrayList<Reservation>();
		temp = list;

		assertEquals(list, temp);
		assertEquals(list.size(), 1);

		list = ctrl.cancel(donald, d2, from1, to1, r2);
		temp = list;

		assertEquals(list, temp);
		assertEquals(list.size(), 0);
	}

	@Test
	public void testShowReservations() {
		List<Reservation> list = new ArrayList<Reservation>();
		ReservationController ctrl = new ReservationController(list);
		list = ctrl.reservate(donald, d1, from1, to1, r1);
		list = ctrl.reservate(micky, d2, from2, to2, r2);

		List<Reservation> temp = new ArrayList<Reservation>();
		temp.add(new Reservation(r1, d1, from1, to1, donald));
		temp.add(new Reservation(r2, d2, from2, to2, micky));

		assertEquals(list.get(0).getBooker(), temp.get(0).getBooker());
		assertEquals(list.get(0).getDate(), temp.get(0).getDate());
		assertEquals(list.get(0).getRoom(), temp.get(0).getRoom());

		assertEquals(list.get(1).getBooker(), temp.get(1).getBooker());
		assertEquals(list.get(1).getDate(), temp.get(1).getDate());
		assertEquals(list.get(1).getRoom(), temp.get(1).getRoom());

		/*
		 * not same objects <=> hashcode first object != hashcode second object
		 */
		assertNotEquals(list, temp);
	}
}
