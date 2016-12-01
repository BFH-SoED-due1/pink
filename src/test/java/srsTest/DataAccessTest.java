/**Copyright(c)2016 Berner Fachhochschule,Switzerland.*Project Smart Reservation System.*Distributable under GPL license.See terms of license at gnu.org.*/
package srsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.due1.time.TimeSlotFactory;
import data.DataAccess;
import jpa.Booker;
import jpa.Room;
import jpa.SystemUser;

public class DataAccessTest {
	public final String DEFAULTTIMESLOTFACTORYNAME = "ch.bfh.due1.time.pojo.TimeSlotFactoryImpl";

	private TimeSlotFactory factory;

	private DataAccess dataAccess;

	@Before
	public void setUp() throws Exception {
		this.dataAccess = DataAccess.getInstance();
		String className = System.getProperty("timeslotfactory.name", DEFAULTTIMESLOTFACTORYNAME);
		Class<?> clazz = Class.forName(className);
		this.factory = (TimeSlotFactory) clazz.newInstance();
	}

	@Test
	public void testDataLayerAvailable() {
		assertNotNull(dataAccess);
	}

	///////////////////////// Booker /////////////////////////
	@Test
	public void testregisterBooker() {
		Booker b = this.dataAccess.registerBooker("Hans", "Muster", "hans@muster.ch");
		List<Booker> all = this.dataAccess.getAllBookers();
		assertNotNull(all);
		assertTrue(all.size() > 0);
		assertTrue(all.contains(b));
	}

	@Test
	public void testEditBooker() {
		Booker b1 = this.dataAccess.registerBooker("Hans", "Muster", "hans@muster.ch");
		String newFirstName = "Hansli";
		String newLastName = "Musterli";

		this.dataAccess.editBooker(newFirstName, newLastName, b1.getId());

		assertEquals(newFirstName, b1.getFirstName());
		assertEquals(newLastName, b1.getLastName());
	}

	@Test
	public void testDeleteBooker() {
		Booker b1 = this.dataAccess.registerBooker("Hans", "Muster", "hans@muster.ch");
		Booker b2 = this.dataAccess.registerBooker("Fritz", "Meier", "hans@muster.ch");
		List<Booker> all = this.dataAccess.getAllBookers();

		assertTrue(all.contains(b1));
		assertTrue(all.contains(b2));

		this.dataAccess.deleteBooker(b1.getId());
		all = this.dataAccess.getAllBookers();

		assertTrue(all.contains(b2));
		assertFalse(all.contains(b1));
	}

	///////////////////////// Room /////////////////////////
	@Test
	public void testInsertRoom() {
		Room r = this.dataAccess.insertRoom(68, "121", "Classroom");
		List<Room> all = this.dataAccess.getAllRooms();
		assertNotNull(all);
		assertTrue(all.size() > 0);
		assertTrue(all.contains(r));
	}

	@Test
	public void testEditRoom() {
		Room r = this.dataAccess.insertRoom(68, "122", "Classroom");
		int newSize = 72;
		String newName = "521";
		String newDescription = "Conference room";

		this.dataAccess.editRoom(newSize, newName, newDescription, r.getId());

		assertEquals(newSize, r.getSize());
		assertEquals(newName, r.getName());
		assertEquals(newDescription, r.getDescription());
	}

	// @Test
	// public void testAddEquipment() {
	// Room r = this.dataAccess.insertRoom(68, "123", "Classroom");
	// RoomEquipment equipment = this.dataAccess.insertRoomEquipment("Beamer",
	// 2);
	//
	// this.dataAccess.addEquipment(equipment, r.getId());
	//
	// List<RoomEquipment> all = this.dataAccess.getAllEquipments(r.getId());
	// all = r.getEquipmentList();
	//
	// assertTrue(all.size() > 0);
	// assertTrue(all.contains(equipment));
	// }

	// @Test
	// public void testRemoveEquipment() {
	// Room r = this.dataAccess.insertRoom(68, "124", "Classroom");
	// RoomEquipment equipment = new RoomEquipment("Blackboard", 1, r);
	//
	// this.dataAccess.addEquipment(equipment, r.getId());
	//
	// List<RoomEquipment> all = this.dataAccess.getAllEquipments(r.getId());
	//
	// assertTrue(all.contains(equipment));
	// }

	@Test
	public void testDeleteRoom() {
		Room r1 = this.dataAccess.insertRoom(68, "125", "Classroom");
		Room r2 = this.dataAccess.insertRoom(78, "521", "Comference Room");
		List<Room> all = this.dataAccess.getAllRooms();

		assertTrue(all.contains(r1));
		assertTrue(all.contains(r2));

		this.dataAccess.deleteRoom(r1.getId());
		all = this.dataAccess.getAllRooms();

		assertTrue(all.contains(r2));
		assertFalse(all.contains(r1));
	}

	///////////////////////// SystemUser /////////////////////////
	@Test
	public void testregisterUser() {
		SystemUser u = this.dataAccess.registerSystemUser("Hans", "Muster", "hans@muster.ch", "111", true);
		List<SystemUser> all = this.dataAccess.getAllSystemUsers();
		assertNotNull(all);
		assertTrue(all.size() > 0);
		assertTrue(all.contains(u));
	}

	@Test
	public void testEditUser() {
		SystemUser u = this.dataAccess.registerSystemUser("Hans", "Muster", "hans@muster1.ch", "111", true);
		String newFirstName = "Hansli";
		String newLastName = "Musterli";
		String newPassword = "222";

		this.dataAccess.editSystemUser(newFirstName, newLastName, newPassword, u.getId());

		assertEquals(newFirstName, u.getFirstName());
		assertEquals(newLastName, u.getLastName());
		assertEquals(newPassword, u.getPassword());
	}

	@Test
	public void testDeleteUser() {
		SystemUser u1 = this.dataAccess.registerSystemUser("Hans", "Muster", "hans@muster2.ch", "111", true);
		SystemUser u2 = this.dataAccess.registerSystemUser("Fritz", "Meier", "fritz@meier.ch", "222", false);
		List<SystemUser> all = this.dataAccess.getAllSystemUsers();

		assertTrue(all.contains(u1));
		assertTrue(all.contains(u2));

		this.dataAccess.deleteSystemUser(u1.getId());
		all = this.dataAccess.getAllSystemUsers();

		assertTrue(all.contains(u2));
		assertFalse(all.contains(u1));
	}

	///////////////////////// Reservation /////////////////////////
	// @Test
	// public void testInsertReservation() {
	// Room room = this.dataAccess.insertRoom(68, "321", "Classroom");
	// Booker booker = this.dataAccess.registerBooker("Hans", "Muster",
	// "hans@muster3.ch");
	// LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
	// LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
	// TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
	//
	// Reservation r = this.dataAccess.insertReservation(room, timeSlot,
	// booker);
	// List<SystemUser> all = this.dataAccess.getAllSystemUsers();
	// assertNotNull(all);
	// assertTrue(all.size() > 0);
	// assertTrue(all.contains(r));
	// }
	//
	// @Test
	// public void testDeleteReservation() {
	// Room room = this.dataAccess.insertRoom(68, "126", "Classroom");
	// Room otherRoom = this.dataAccess.insertRoom(68, "127", "Classroom");
	// Booker booker = this.dataAccess.registerBooker("Hans", "Muster",
	// "hans@muster.ch");
	// Booker otherBbooker = this.dataAccess.registerBooker("Hans", "Muster",
	// "hans@muster4.ch");
	// LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
	// LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
	// TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);
	// LocalDateTime otherStart = LocalDateTime.of(2016, 11, 24, 9, 15);
	// LocalDateTime otherFinish = LocalDateTime.of(2016, 11, 24, 9, 45);
	// TimeSlot otherRimeSlot = this.factory.createTimeSlot(otherStart,
	// otherFinish);
	//
	// Reservation r = this.dataAccess.insertReservation(room, timeSlot,
	// booker);
	// Reservation otherr = this.dataAccess.insertReservation(otherRoom,
	// otherRimeSlot, otherBbooker);
	// List<Booker> all = this.dataAccess.getAllBookers();
	//
	// assertTrue(all.contains(r));
	// assertTrue(all.contains(otherr));
	//
	// this.dataAccess.deleteBooker(r.getId());
	// all = this.dataAccess.getAllBookers();
	//
	// assertTrue(all.contains(otherr));
	// assertFalse(all.contains(r));
	// }
}
