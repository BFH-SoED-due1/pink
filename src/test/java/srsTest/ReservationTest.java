/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package srsTest;

import static org.junit.Assert.*;
import java.sql.Time;
import java.util.Date;
import org.junit.Test;

import srs.BookerName;
import srs.Booker;
import srs.BookerAddress;
import srs.Reservation;
import srs.Room;

public class ReservationTest {
	//Test reservation
	@SuppressWarnings("deprecation")
	@Test
	public void testBookerFirstName() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals("Fritzli", reservation.getBooker().getFirstName());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBookerLastName() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals("Müller", reservation.getBooker().getLastName());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressCountry() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals("Switzerland", reservation.getBooker().getCountry());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressStreet() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(reservation.getBooker().getStreet(), "Musterstrasse");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressStreetNumber() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals("1", reservation.getBooker().getStreetNumber());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressPostcode() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(1111, reservation.getBooker().getPostcode());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressVillage() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals("Musterhausen", reservation.getBooker().getVillage());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testBookerAddressEmail() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals("a@b.ch", reservation.getBooker().getEmail());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReservationYear() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(2016, reservation.getDate().getYear());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReservationMonth() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(10, reservation.getDate().getMonth());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeHourFrom() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(16, reservation.getFrom().getHours());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeHourUntil() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(20, reservation.getUntil().getHours());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeMinuteFrom() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 01, 00);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(01, reservation.getFrom().getMinutes());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeMinuteUntil() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 30, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(30, reservation.getUntil().getMinutes());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeSecondFrom() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 22);
		Time until = new Time(20, 00, 00);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(22, reservation.getFrom().getSeconds());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReservationTimeSecondUntil() {
		Room r = new Room(123, "Room123", "Description");
		
		Date d = new Date(2016, 10, 10);
		Time from = new Time(16, 00, 00);
		Time until = new Time(20, 00, 44);
		
		BookerName n = new BookerName("Fritzli", "Müller");
		BookerAddress b = new BookerAddress("Switzerland", "Musterstrasse", "1", 1111, "Musterhausen", "a@b.ch");
		Booker booker = new Booker(n, b);
		
		Reservation reservation = new Reservation(r, d, from, until, booker);
		
		assertEquals(44, reservation.getUntil().getSeconds());
	}
}
