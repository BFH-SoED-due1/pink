/**Copyright(c)2016 Berner Fachhochschule,Switzerland.*Project Smart Reservation System.*Distributable under GPL license.See terms of license at gnu.org.*/
package ch.bfh.ti.soed.hs16.controllerTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.due1.time.TimeSlot;
import ch.bfh.due1.time.TimeSlotFactory;
import ch.bfh.ti.soed.hs16.srs.controller.BookerController;
import ch.bfh.ti.soed.hs16.srs.controller.ReservationController;
import ch.bfh.ti.soed.hs16.srs.controller.RoomController;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.ReservationException;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.ReservationNotFoundException;
import ch.bfh.ti.soed.hs16.srs.model.Booker;
import ch.bfh.ti.soed.hs16.srs.model.Reservation;
import ch.bfh.ti.soed.hs16.srs.model.Room;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IReservation;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;

public class ReservationControllerTest {
	private ReservationController resController;
	private RoomController roomController;
	private BookerController bookerController;
	public final String DEFAULTTIMESLOTFACTORYNAME = "ch.bfh.due1.time.pojo.TimeSlotFactoryImpl";

	private TimeSlotFactory factory;

	String fNameDonald = "Donald";
	String lNameDonald = "Duck";
	String emailDonald = "donald@disney.com";

	String fNameMicky = "";
	String lNameMicky = "Mouse";
	String emailMicky = "micky#mouse.com";

	IBooker donald = new Booker(fNameDonald, lNameDonald, emailDonald);
	IBooker micky = new Booker(fNameMicky, lNameMicky, emailMicky);

	IRoom r1 = new Room(100, "Room 1", "Beamer, Seats, Computer");
	IRoom r2 = new Room(200, "Room 2", "Beamer, Seats, Computer, TV");
	IRoom r3 = new Room(10, "Pause 1", "Coffeemashine, Sandwich");
	IRoom r4 = new Room(20, "Pause 2", "Coffeemashine, Sandwich");

	@Before
	public void setUp() throws Exception {
		resController = new ReservationController();
		roomController = new RoomController();
		bookerController = new BookerController();
		String className = System.getProperty("timeslotfactory.name", DEFAULTTIMESLOTFACTORYNAME);
		Class<?> clazz = Class.forName(className);
		this.factory = (TimeSlotFactory) clazz.newInstance();
	}

	@Test
	public void testReservateNormal() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		String name = "9911";
		int size = 24;
		String descr = "Classroom";
		this.roomController.addRoom(size, name, descr);
		IRoom room = this.roomController.getRoomByName(name);

		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans91@muster.ch";
		this.bookerController.saveBooker(firstName, lastName, email);
		IBooker booker = this.bookerController.getBookerByEmail(email);

		IReservation r = new Reservation(room, timeSlot, booker);

		this.resController.reservate(r);

		List<IReservation> list = this.resController.listAllReservations();

		assertTrue(list.contains(r));
	}

	@Test(expected = ReservationException.class)
	public void testReservateExpectException() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		String name = "9912";
		int size = 24;
		String descr = "Classroom";
		this.roomController.addRoom(size, name, descr);
		IRoom room = this.roomController.getRoomByName(name);

		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans92@muster.ch";
		this.bookerController.saveBooker(firstName, lastName, email);
		IBooker booker = this.bookerController.getBookerByEmail(email);

		IReservation r = new Reservation(room, timeSlot, booker);
		IReservation error = new Reservation(room, timeSlot, new Booker("Mickey", "Mouse", "mickey@mouse.ch"));

		this.resController.reservate(r);
		this.resController.reservate(error);
	}

	@Test
	public void testCancel() throws ReservationNotFoundException {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
		LocalDateTime otherStart = LocalDateTime.of(2016, 12, 24, 10, 15);
		LocalDateTime otherFinish = LocalDateTime.of(2016, 12, 24, 10, 45);
		TimeSlot otherTimeSlot = this.factory.createTimeSlot(otherStart, otherFinish);

		String name = "9913";
		int size = 24;
		String descr = "Classroom";
		this.roomController.addRoom(size, name, descr);
		IRoom room = this.roomController.getRoomByName(name);

		String name2 = "9914";
		int size2 = 24;
		String descr2 = "Classroom";
		this.roomController.addRoom(size2, name2, descr2);
		IRoom room2 = this.roomController.getRoomByName(name2);

		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans93@muster.ch";
		this.bookerController.saveBooker(firstName, lastName, email);
		IBooker booker = this.bookerController.getBookerByEmail(email);

		IReservation r = new Reservation(room, timeSlot, booker);
		IReservation rOther = new Reservation(room2, otherTimeSlot, booker);

		this.resController.reservate(r);
		this.resController.reservate(rOther);

		List<IReservation> list = this.resController.listAllReservations();

		assertTrue(list.contains(r));
		assertTrue(list.contains(rOther));

		this.resController.cancel(r);

		list = this.resController.listAllReservations();

		assertFalse(list.contains(r));
		assertTrue(list.contains(rOther));
	}

	@Test(expected = ReservationNotFoundException.class)
	public void testCancelNotExistingReservation() throws ReservationNotFoundException {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		String name = "9916";
		int size = 24;
		String descr = "Classroom";
		this.roomController.addRoom(size, name, descr);
		IRoom room = this.roomController.getRoomByName(name);

		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans96@muster.ch";
		this.bookerController.saveBooker(firstName, lastName, email);
		IBooker booker = this.bookerController.getBookerByEmail(email);

		IReservation r = new Reservation(room, timeSlot, booker);

		this.resController.cancel(r);
	}

	@Test
	public void testShowReservations() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		String name = "9915";
		int size = 24;
		String descr = "Classroom";
		this.roomController.addRoom(size, name, descr);
		IRoom room = this.roomController.getRoomByName(name);

		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans95@muster.ch";
		this.bookerController.saveBooker(firstName, lastName, email);
		IBooker booker = this.bookerController.getBookerByEmail(email);

		IReservation r = new Reservation(room, timeSlot, booker);

		this.resController.reservate(r);

		List<IReservation> list = this.resController.listAllReservations();

		assertTrue(list.size() >= 1);
	}
}
