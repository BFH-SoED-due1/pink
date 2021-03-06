/**Copyright(c)2016 Berner Fachhochschule,Switzerland.*Project Smart Reservation System.*Distributable under GPL license.See terms of license at gnu.org.*/
package ch.bfh.ti.soed.hs16.dbTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.due1.time.TimeSlot;
import ch.bfh.due1.time.TimeSlotFactory;
import ch.bfh.ti.soed.hs16.srs.db.DataAccess;
import ch.bfh.ti.soed.hs16.srs.model.Reservation;
import ch.bfh.ti.soed.hs16.srs.model.RoomEquipment;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IReservation;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;
import ch.bfh.ti.soed.hs16.srs.srsInterface.ISystemUser;

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
		IBooker b = this.dataAccess.registerBooker("Hans", "Muster", "hans@muster.ch");
		List<IBooker> all = this.dataAccess.getAllBookers();
		assertNotNull(all);
		assertTrue(all.size() > 0);
		assertTrue(all.contains(b));
	}

	@Test
	public void testEditBooker() {
		IBooker b1 = this.dataAccess.registerBooker("Hans", "Muster", "hans@muster1.ch");
		String newFirstName = "Hansli";
		String newLastName = "Musterli";

		this.dataAccess.editBooker(newFirstName, newLastName, b1.getId());

		assertEquals(newFirstName, b1.getFirstName());
		assertEquals(newLastName, b1.getLastName());
	}

	@Test
	public void testDeleteBooker() {
		IBooker b1 = this.dataAccess.registerBooker("Hans", "Muster", "hans@muster2.ch");
		IBooker b2 = this.dataAccess.registerBooker("Fritz", "Meier", "fritz@meier.ch");
		List<IBooker> all = this.dataAccess.getAllBookers();

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
		IRoom r = this.dataAccess.insertRoom(68, "121", "Classroom");
		List<IRoom> all = this.dataAccess.getAllRooms();
		assertNotNull(all);
		assertTrue(all.size() > 0);
		assertTrue(all.contains(r));
	}

	@Test
	public void testEditRoom() {
		IRoom r = this.dataAccess.insertRoom(68, "122", "Classroom");
		int newSize = 72;
		String newName = "521";
		String newDescription = "Conference room";

		this.dataAccess.editRoom(newSize, newName, newDescription, r.getId());

		assertEquals(newSize, r.getSize());
		assertEquals(newName, r.getName());
		assertEquals(newDescription, r.getDescription());
	}

	@Test
	public void testAddEquipment() {
		IRoom r = this.dataAccess.insertRoom(68, "123", "Classroom");
		RoomEquipment equipment = this.dataAccess.insertRoomEquipment("Beamer", 2);

		this.dataAccess.addEquipment(equipment, r.getId());

		List<RoomEquipment> all = this.dataAccess.getAllEquipments(r.getId());
		all = r.getEquipmentList();

		assertTrue(all.size() > 0);
		assertTrue(all.contains(equipment));
	}

	@Test
	public void testRemoveaEquipment() {
		IRoom r = this.dataAccess.insertRoom(68, "124", "Classroom");
		RoomEquipment equipment = this.dataAccess.insertRoomEquipment("Beamer", 2);

		this.dataAccess.addEquipment(equipment, r.getId());

		this.dataAccess.removeEquipment(equipment, r.getId());

		List<RoomEquipment> all = this.dataAccess.getAllEquipments(r.getId());
		assertTrue(all.size() == 0);
		assertFalse(all.contains(equipment));
	}

	@Test
	public void testDeleteRoom() {
		IRoom r1 = this.dataAccess.insertRoom(68, "125", "Classroom");
		IRoom r2 = this.dataAccess.insertRoom(78, "521", "Comference Room");
		List<IRoom> all = this.dataAccess.getAllRooms();

		assertTrue(all.contains(r1));
		assertTrue(all.contains(r2));

		this.dataAccess.deleteRoom(r1.getId());
		all = this.dataAccess.getAllRooms();

		assertTrue(all.contains(r2));
		assertFalse(all.contains(r1));
	}

	///////////////////////// RoomEquipment /////////////////////////

	@Test
	public void testEditRoomEquipment() {
		IRoom r = this.dataAccess.insertRoom(68, "123", "Classroom");
		RoomEquipment equipment = this.dataAccess.insertRoomEquipment("Beamer", 2);

		this.dataAccess.addEquipment(equipment, r.getId());

		int newQty = 4;
		this.dataAccess.editRoomEquipment(newQty, equipment.getId());

		assertEquals(newQty, equipment.getQuantity());
	}

	@Test
	public void testDeleteRoomEquipment() {
		RoomEquipment e1 = this.dataAccess.insertRoomEquipment("Beamer", 2);
		RoomEquipment e2 = this.dataAccess.insertRoomEquipment("Blackboard", 1);
		List<RoomEquipment> all = this.dataAccess.getAllRoomEquipments();

		assertTrue(all.contains(e1));
		assertTrue(all.contains(e2));

		this.dataAccess.deleteRoomRoomEquipment(e1.getId());
		all = this.dataAccess.getAllRoomEquipments();

		assertTrue(all.contains(e2));
		assertFalse(all.contains(e1));

	}

	///////////////////////// SystemUser /////////////////////////
	@Test
	public void testregisterUser() {
		ISystemUser u = this.dataAccess.registerSystemUser("Hans", "Muster", "hans@muster3.ch", "111", true);
		List<ISystemUser> all = this.dataAccess.getAllSystemUsers();
		assertNotNull(all);
		assertTrue(all.size() > 0);
		assertTrue(all.contains(u));
	}

	@Test
	public void testEditUser() {
		ISystemUser u = this.dataAccess.registerSystemUser("Hans", "Muster", "hans@muster4.ch", "111", true);
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
		ISystemUser u1 = this.dataAccess.registerSystemUser("Hans", "Muster", "hans@muster5.ch", "111", true);
		ISystemUser u2 = this.dataAccess.registerSystemUser("Fritz", "Meier", "fritz@meier2.ch", "222", false);
		List<ISystemUser> all = this.dataAccess.getAllSystemUsers();

		assertTrue(all.contains(u1));
		assertTrue(all.contains(u2));

		this.dataAccess.deleteSystemUser(u1.getId());
		all = this.dataAccess.getAllSystemUsers();

		assertTrue(all.contains(u2));
		assertFalse(all.contains(u1));
	}

	///////////////////////// Reservation /////////////////////////
	@Test
	public void testInsertReservation() {
		IRoom room = this.dataAccess.insertRoom(68, "321", "Classroom");
		IBooker booker = this.dataAccess.registerBooker("Hans", "Muster", "hans@muster6.ch");
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		IReservation res = new Reservation(room, timeSlot, booker);

		IReservation r = this.dataAccess.insertReservation(res);
		List<IReservation> all = this.dataAccess.getAllReservations();
		assertNotNull(all);
		assertTrue(all.size() > 0);
		assertTrue(all.contains(r));
	}

	@Test
	public void testDeleteReservation() {
		IRoom room = this.dataAccess.insertRoom(68, "126", "Classroom");
		IBooker booker = this.dataAccess.registerBooker("Hans", "Muster", "hans@muster7.ch");
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		TimeSlot timeSlot = this.factory.createTimeSlot(start, finish);

		IReservation res = new Reservation(room, timeSlot, booker);
		IReservation resOther = new Reservation(room, timeSlot, booker);

		IReservation r = this.dataAccess.insertReservation(res);
		IReservation other = this.dataAccess.insertReservation(resOther);
		List<IReservation> all = this.dataAccess.getAllReservations();

		assertTrue(all.contains(r));
		assertTrue(all.contains(other));

		this.dataAccess.cancelReservation(r.getId());
		all = this.dataAccess.getAllReservations();

		assertTrue(all.contains(other));
		assertFalse(all.contains(r));
	}
}
