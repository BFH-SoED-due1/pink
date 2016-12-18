/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package srsTest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.due1.time.TimeSlot;
import ch.bfh.due1.time.TimeSlotFactory;
import ch.bfh.ti.soed.hs16.srs.model.Booker;
import ch.bfh.ti.soed.hs16.srs.model.Reservation;
import ch.bfh.ti.soed.hs16.srs.model.Room;

public class ReservationTest {
	public final String DEFAULTTIMESLOTFACTORYNAME = "ch.bfh.due1.time.pojo.TimeSlotFactoryImpl";

	private TimeSlotFactory factory;

	@Before
	public void setUp() throws Exception {
		String className = System.getProperty("timeslotfactory.name", DEFAULTTIMESLOTFACTORYNAME);
		Class<?> clazz = Class.forName(className);
		this.factory = (TimeSlotFactory) clazz.newInstance();
	}

	@Test
	public void testBookerFirstName() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		Room r = new Room(123, "Room123", "Description");
		Booker booker = new Booker("Hans", "Zimmer", "hans@zimmer.ch");
		Reservation reservation = new Reservation(r, timeSlot, booker);

		assertEquals("Hans", reservation.getBooker().getFirstName());
	}

	@Test
	public void testBookerLastName() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		Room r = new Room(123, "Room123", "Description");
		Booker booker = new Booker("Hans", "Zimmer", "hans@zimmer.ch");
		Reservation reservation = new Reservation(r, timeSlot, booker);

		assertEquals("Zimmer", reservation.getBooker().getLastName());
	}

	@Test
	public void testBookerAddressEmail() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		Room r = new Room(123, "Room123", "Description");
		Booker booker = new Booker("Hans", "Zimmer", "hans@zimmer.ch");
		Reservation reservation = new Reservation(r, timeSlot, booker);

		assertEquals("hans@zimmer.ch", reservation.getBooker().getLogin());
	}

	@Test
	public void testSetRoom() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		Room r1 = new Room(123, "Room123", "Description132");
		Room r2 = new Room(124, "Room124", "Description124");

		Booker booker = new Booker("Hans", "Zimmer", "hans@zimmer.ch");
		Reservation res = new Reservation(r1, timeSlot, booker);
		assertEquals(res.getRoom().getName(), "Room123");

		res.setRoom(r2);
		assertEquals(res.getRoom().getName(), "Room124");
	}

	@Test
	public void testSetTimeSlot() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
		LocalDateTime newStart = LocalDateTime.of(2016, 11, 24, 10, 15);
		LocalDateTime newFinish = LocalDateTime.of(2016, 11, 24, 10, 45);
		TimeSlot newTimeSlot = this.factory.createTimeSlot(newStart, newFinish);

		Room r = new Room(123, "Room123", "Description132");

		Booker booker = new Booker("Hans", "Zimmer", "hans@zimmer.ch");
		Reservation res = new Reservation(r, timeSlot, booker);
		assertEquals(res.getRoom().getName(), "Room123");

		res.setTimeSlot(newTimeSlot);
		assertEquals(res.getTimeSlot(), newTimeSlot);
	}

	@Test
	public void setBooker() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		Room r = new Room(123, "Room123", "Description132");

		Booker booker = new Booker("Hans", "Zimmer", "hans@zimmer.ch");
		Booker booker2 = new Booker("Kari", "Meyer", "kari@meyer.ch");

		Reservation res = new Reservation(r, timeSlot, booker);
		assertEquals("Hans", res.getBooker().getFirstName());
		assertEquals("Zimmer", res.getBooker().getLastName());
		assertEquals("hans@zimmer.ch", res.getBooker().getLogin());

		res.setBooker(booker2);
		assertEquals("Kari", res.getBooker().getFirstName());
		assertEquals("Meyer", res.getBooker().getLastName());
		assertEquals("kari@meyer.ch", res.getBooker().getLogin());

	}
}
