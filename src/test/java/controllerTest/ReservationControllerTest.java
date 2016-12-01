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
import control.ABooker;
import control.AReservation;
import control.ARoom;
import control.ReservationController;
import model.Booker;
import model.Reservation;
import model.Room;

public class ReservationControllerTest {
	public final String DEFAULTTIMESLOTFACTORYNAME = "ch.bfh.due1.time.pojo.TimeSlotFactoryImpl";

	private TimeSlotFactory factory;

	String fNameDonald = "Donald";
	String lNameDonald = "Duck";
	String emailDonald = "donald@disney.com";

	String fNameMicky = "Micky";
	String lNameMicky = "Mouse";
	String emailMicky = "micky@mouse.com";

	Booker donald = new Booker(fNameDonald, lNameDonald, emailDonald);
	ABooker micky = new Booker(fNameDonald, lNameMicky, emailMicky);

	Room r1 = new Room(100, "Room 1", "Beamer, Seats, Computer");
	ARoom r2 = new Room(200, "Room 2", "Beamer, Seats, Computer, TV");
	ARoom r3 = new Room(10, "Pause 1", "Coffeemashine, Sandwich");
	ARoom r4 = new Room(20, "Pause 2", "Coffeemashine, Sandwich");

	/**
	 * Constructs a time slot factory object by using the
	 * <code>timeslotfactory.name</code> property. If not set then the
	 * <code>ch.bfh.due1.time.TimeSlotFactoryImpl</code> is used.
	 */
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
		LocalDateTime newStart = LocalDateTime.of(2016, 11, 24, 10, 15);
		LocalDateTime newFinish = LocalDateTime.of(2016, 11, 24, 10, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
		TimeSlot newTimeSlot = this.factory.createTimeSlot(newStart, newFinish);

		List<AReservation> list = new ArrayList<AReservation>();
		ReservationController ctrl = new ReservationController(list);

		AReservation res = new Reservation(r1, timeSlot, donald);

		list = ctrl.reservate(res);

		List<Reservation> list2 = new ArrayList<Reservation>();
		list2.add((Reservation) res);

		assertEquals(list2, list);
	}

	// @Test(expected = ReservationException.class)
	// public void testReservateExpectException() {
	// LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
	// LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
	// TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
	// LocalDateTime newStart = LocalDateTime.of(2016, 11, 24, 10, 15);
	// LocalDateTime newFinish = LocalDateTime.of(2016, 11, 24, 10, 45);
	// TimeSlot newTimeSlot = this.factory.createTimeSlot(newStart, newFinish);
	//
	// List<Reservation> list = new ArrayList<Reservation>();
	// ReservationController ctrl = new ReservationController(list);
	// list = ctrl.reservate(donald, timeSlot, r1);
	// list = ctrl.reservate(micky, newTimeSlot, r1);
	// }
	//
	// @Test
	// public void testCancel() throws ReservationNotFoundException {
	// LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
	// LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
	// TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
	// LocalDateTime newStart = LocalDateTime.of(2016, 11, 24, 10, 15);
	// LocalDateTime newFinish = LocalDateTime.of(2016, 11, 24, 10, 45);
	// TimeSlot newTimeSlot = this.factory.createTimeSlot(newStart, newFinish);
	//
	// List<Reservation> list = new ArrayList<Reservation>();
	// ReservationController ctrl = new ReservationController(list);
	// list = ctrl.reservate(donald, timeSlot, r1);
	// list = ctrl.reservate(donald, newTimeSlot, r2);
	//
	// List<Reservation> temp = new ArrayList<Reservation>();
	// temp = list;
	//
	// assertEquals(list, temp);
	// assertEquals(list.size(), 2);
	//
	// list = ctrl.cancel(donald, timeSlot, r1);
	// temp = list;
	//
	// assertEquals(list, temp);
	// assertEquals(list.size(), 1);
	// }
	//
	// @Test(expected = ReservationNotFoundException.class)
	// public void testCancelThrowException() throws
	// ReservationNotFoundException {
	// LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
	// LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
	// TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
	// LocalDateTime newStart = LocalDateTime.of(2016, 11, 24, 10, 15);
	// LocalDateTime newFinish = LocalDateTime.of(2016, 11, 24, 10, 45);
	// TimeSlot newTimeSlot = this.factory.createTimeSlot(newStart, newFinish);
	//
	// List<Reservation> list = new ArrayList<Reservation>();
	// ReservationController ctrl = new ReservationController(list);
	// list = ctrl.reservate(donald, timeSlot, r1);
	//
	// List<Reservation> temp = new ArrayList<Reservation>();
	// temp = list;
	//
	// assertEquals(list, temp);
	// assertEquals(list.size(), 1);
	//
	// list = ctrl.cancel(donald, newTimeSlot, r2);
	// temp = list;
	//
	// assertEquals(list, temp);
	// assertEquals(list.size(), 0);
	// }
	//
	// @Test
	// public void testShowReservations() {
	// LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
	// LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
	// TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
	// LocalDateTime newStart = LocalDateTime.of(2016, 11, 24, 10, 15);
	// LocalDateTime newFinish = LocalDateTime.of(2016, 11, 24, 10, 45);
	// TimeSlot newTimeSlot = this.factory.createTimeSlot(newStart, newFinish);
	//
	// List<Reservation> list = new ArrayList<Reservation>();
	// ReservationController ctrl = new ReservationController(list);
	// list = ctrl.reservate(donald, timeSlot, r1);
	// list = ctrl.reservate(micky, newTimeSlot, r2);
	//
	// List<Reservation> temp = new ArrayList<Reservation>();
	// temp.add(new Reservation(r1, timeSlot, donald));
	// temp.add(new Reservation(r2, newTimeSlot, micky));
	//
	// assertEquals(list.get(0).getBooker(), temp.get(0).getBooker());
	// assertEquals(list.get(0).getTimeSlot(), temp.get(0).getTimeSlot());
	// assertEquals(list.get(0).getRoom(), temp.get(0).getRoom());
	//
	// assertEquals(list.get(1).getBooker(), temp.get(1).getBooker());
	// assertEquals(list.get(1).getTimeSlot(), temp.get(1).getTimeSlot());
	// assertEquals(list.get(1).getRoom(), temp.get(1).getRoom());
	//
	// /*
	// * not same objects <=> hashcode first object != hashcode second object
	// */
	// assertNotEquals(list, temp);
	// }
}
