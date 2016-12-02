/**Copyright(c)2016 Berner Fachhochschule,Switzerland.*Project Smart Reservation System.*Distributable under GPL license.See terms of license at gnu.org.*/
package controllerTest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.due1.time.TimeSlot;
import ch.bfh.due1.time.TimeSlotFactory;
import control.AReservation;
import control.ReservationController;
import control.exceptions.ReservationException;
import control.exceptions.ReservationNotFoundException;
import model.Booker;
import model.Reservation;
import model.Room;

public class ReservationControllerTest {
	public final String DEFAULTTIMESLOTFACTORYNAME = "ch.bfh.due1.time.pojo.TimeSlotFactoryImpl";

	private TimeSlotFactory factory;

	String fNameDonald = "Donald";
	String lNameDonald = "Duck";
	String emailDonald = "donald@disney.com";

	String fNameMicky = "";
	String lNameMicky = "Mouse";
	String emailMicky = "micky#mouse.com";

	Booker donald = new Booker(fNameDonald, lNameDonald, emailDonald);
	Booker micky = new Booker(fNameMicky, lNameMicky, emailMicky);

	Room r1 = new Room(100, "Room 1", "Beamer, Seats, Computer");
	Room r2 = new Room(200, "Room 2", "Beamer, Seats, Computer, TV");
	Room r3 = new Room(10, "Pause 1", "Coffeemashine, Sandwich");
	Room r4 = new Room(20, "Pause 2", "Coffeemashine, Sandwich");

	@Before
	public void setUp() throws Exception {
		String className = System.getProperty("timeslotfactory.name", DEFAULTTIMESLOTFACTORYNAME);
		Class<?> clazz = Class.forName(className);
		this.factory = (TimeSlotFactory) clazz.newInstance();
	}

	@Test
	public void testReservateNormal() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		List<AReservation> list = new ArrayList<AReservation>();
		ReservationController ctrl = new ReservationController(list);

		AReservation res = new Reservation(r1, timeSlot, donald);

		list = ctrl.reservate(res);

		List<Reservation> list2 = new ArrayList<Reservation>();
		list2.add((Reservation) res);

		assertEquals(list2, list);
	}

	@Test(expected = ReservationException.class)
	public void testReservateExpectException() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		List<AReservation> list = new ArrayList<AReservation>();
		ReservationController ctrl = new ReservationController(list);

		AReservation res = new Reservation(r1, timeSlot, donald);
		AReservation error = new Reservation(r1, timeSlot, micky);

		list = ctrl.reservate(res);
		list = ctrl.reservate(error);
	}

	@Test(expected = ReservationNotFoundException.class)
	public void testCancelThrowException() throws ReservationNotFoundException {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
		LocalDateTime newStart = LocalDateTime.of(2016, 12, 24, 10, 15);
		LocalDateTime newFinish = LocalDateTime.of(2016, 12, 24, 10, 45);
		TimeSlot newTimeSlot = this.factory.createTimeSlot(newStart, newFinish);

		List<AReservation> list = new ArrayList<AReservation>();
		ReservationController ctrl = new ReservationController(list);
		AReservation res = new Reservation(r1, timeSlot, donald);
		AReservation res2 = new Reservation(r2, newTimeSlot, micky);

		list = ctrl.reservate(res);

		List<AReservation> temp = new ArrayList<AReservation>();
		temp = list;

		assertEquals(list, temp);
		assertEquals(list.size(), 1);

		list = ctrl.cancel(res2);
		temp = list;

		assertEquals(list, temp);
		assertEquals(list.size(), 1);
	}

	/* TODO */
	// @Test
	// public void testCancel() throws ReservationNotFoundException {
	// LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
	// LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
	// TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
	// LocalDateTime otherStart = LocalDateTime.of(2016, 12, 24, 10, 15);
	// LocalDateTime otherFinish = LocalDateTime.of(2016, 12, 24, 10, 45);
	// TimeSlot otherTimeSlot = this.factory.createTimeSlot(otherStart,
	// otherFinish);
	//
	// List<AReservation> list = new ArrayList<AReservation>();
	// ReservationController ctrl = new ReservationController(list);
	// AReservation res = new Reservation(r1, timeSlot, donald);
	//
	// list = ctrl.reservate(res);
	//
	// List<AReservation> temp = new ArrayList<AReservation>();
	// temp = list;
	//
	// assertEquals(list.size(), 1);
	//
	// list = ctrl.cancel(res);
	// temp = list;
	// assertEquals(list, temp);
	// assertEquals(list.size(), 0);
	// }

	@Test
	public void testShowReservations() {
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		List<AReservation> list = new ArrayList<AReservation>();
		ReservationController ctrl = new ReservationController(list);
		AReservation res = new Reservation(r3, timeSlot, donald);

		list = ctrl.reservate(res);

		assertEquals(list.get(0).getBooker(), res.getBooker());
		assertEquals(list.get(0).getTimeSlot(), res.getTimeSlot());
		assertEquals(list.get(0).getRoom(), res.getRoom());
	}
}
