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
		
		assertEquals(reservation.getBooker().getFirstName(), "Fritzli");
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
		
		assertEquals(reservation.getBooker().getLastName(), "Müller");
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
		
		assertEquals(reservation.getBooker().getCountry(), "Switzerland");
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
		
		assertEquals(reservation.getBooker().getStreetNumber(), "1");
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
		
		assertEquals(reservation.getBooker().getPostcode(), 1111);
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
		
		assertEquals(reservation.getBooker().getVillage(), "Musterhausen");
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
		
		assertEquals(reservation.getBooker().getEmail(), "a@b.ch");
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
		
		assertEquals(reservation.getDate().getYear(), 2016);
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
		
		assertEquals(reservation.getDate().getMonth(), 10);
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
		
		assertEquals(reservation.getFrom().getHours(), 16);
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
		
		assertEquals(reservation.getUntil().getHours(), 20);
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
		
		assertEquals(reservation.getFrom().getMinutes(), 01);
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
		
		assertEquals(reservation.getUntil().getMinutes(), 30);
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
		
		assertEquals(reservation.getFrom().getSeconds(), 22);
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
		
		assertEquals(reservation.getUntil().getSeconds(), 44);
	}
}
