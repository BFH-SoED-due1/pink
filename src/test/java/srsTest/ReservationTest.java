/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/

package srsTest;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import srs.Booker;
import srs.BookerAddress;
import srs.BookerName;
import srs.Reservation;
import srs.Room;

public class ReservationTest {
	// Test reservation
	@SuppressWarnings("deprecation")
	@Test
	public void testBookerFirstName() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals("Fritzli", reservation.getBooker().getFirstName());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBookerLastName() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals("Müller", reservation.getBooker().getLastName());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressCountry() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals("Switzerland", reservation.getBooker().getCountry());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressStreet() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(reservation.getBooker().getStreet(), "Musterstrasse");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressStreetNumber() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals("1", reservation.getBooker().getStreetNumber());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressPostcode() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(1111, reservation.getBooker().getPostcode());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressVillage() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals("Musterhausen", reservation.getBooker().getVillage());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressEmail() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals("a@b.ch", reservation.getBooker().getEmail());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReservationYear() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(2016, reservation.getDate().getYear());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReservationMonth() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(10, reservation.getDate().getMonth());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeHourFrom() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(16, reservation.getFrom().getHours());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeHourUntil() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(20, reservation.getTo().getHours());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeMinuteFrom() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 01, 00);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(01, reservation.getFrom().getMinutes());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeMinuteUntil() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 30, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(30, reservation.getTo().getMinutes());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeSecondFrom() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 22);
		Time to = new Time(20, 00, 00);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(22, reservation.getFrom().getSeconds());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeSecondUntil() {
		Room r = new Room(123, "Room123", "Description");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 44);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation reservation = new Reservation(r, d, from, to, booker);

		assertEquals(44, reservation.getTo().getSeconds());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetRoom() {
		Room r1 = new Room(123, "Room123", "Description132");
		Room r2 = new Room(124, "Room124", "Description124");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 44);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation res = new Reservation(r1, d, from, to, booker);
		assertEquals(res.getRoom().getName(), "Room123");

		res.setRoom(r2);
		assertEquals(res.getRoom().getName(), "Room124");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetDate() {
		Room r = new Room(123, "Room123", "Description132");

		Date d1 = new Date(2016, 10, 10);
		Date d2 = new Date(2016, 11, 11);
		Time from = new Time(16, 00, 00);
		Time to = new Time(20, 00, 44);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation res = new Reservation(r, d1, from, to, booker);
		assertEquals(res.getDate().getYear(), 2016);
		assertEquals(res.getDate().getMonth(), 10);

		res.setDate(d2);
		assertEquals(res.getDate().getYear(), 2016);
		assertEquals(res.getDate().getMonth(), 11);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetFrom() {
		Room r = new Room(123, "Room123", "Description132");

		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 02, 45);
		Time from2 = new Time(18, 22, 14);

		Time until = new Time(20, 00, 44);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation res = new Reservation(r, d, from, until, booker);
		assertEquals(res.getFrom().getHours(), 16);
		assertEquals(res.getFrom().getMinutes(), 02);
		assertEquals(res.getFrom().getSeconds(), 45);

		res.setFrom(from2);
		assertEquals(res.getFrom().getHours(), 18);
		assertEquals(res.getFrom().getMinutes(), 22);
		assertEquals(res.getFrom().getSeconds(), 14);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetTo() {
		Room r = new Room(123, "Room123", "Description132");

		Date d = new Date(2016, 10, 10);
		Time to = new Time(16, 02, 45); // h, m, s
		Time to2 = new Time(18, 22, 14);

		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);

		Reservation res = new Reservation(r, d, to, to, booker);
		assertEquals(res.getTo().getHours(), 16);
		assertEquals(res.getTo().getMinutes(), 02);
		assertEquals(res.getTo().getSeconds(), 45);

		res.setTo(to2);
		assertEquals(res.getTo().getHours(), 18);
		assertEquals(res.getTo().getMinutes(), 22);
		assertEquals(res.getTo().getSeconds(), 14);
	}

	// @Test
	// public void testSetRoom() {
	//
	// }
}
