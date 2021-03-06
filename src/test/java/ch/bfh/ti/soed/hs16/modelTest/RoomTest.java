/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package ch.bfh.ti.soed.hs16.modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.model.Room;
import ch.bfh.ti.soed.hs16.srs.model.RoomEquipment;

public class RoomTest {
	// Test room
	@Test
	public void testRoomName() {
		String name = "N.321";
		int size = 30;
		String description = "This is a description!";
		String newName = "N.522";

		Room room = new Room(size, name, description);
		assertEquals(name, room.getName());

		room.setName(newName);
		assertEquals(newName, room.getName());
	}

	@Test
	public void testSize() {
		String name = "N.322";
		int size = 30;
		String description = "This is a description!";
		int newSize = 36;

		Room room = new Room(size, name, description);
		assertEquals(size, room.getSize());

		room.setSize(newSize);
		assertEquals(newSize, room.getSize());
	}

	@Test
	public void testDescription() {
		String name = "N.323";
		int size = 30;
		String description = "This is a description!";
		String newDescription = "This is a new description!";

		Room room = new Room(size, name, description);
		assertEquals(description, room.getDescription());

		room.setDescription(newDescription);
		assertEquals(newDescription, room.getDescription());
	}

	@Test
	public void testBookingStatus() {
		String name = "N.323";
		int size = 30;
		String description = "This is a description!";

		Room room = new Room(size, name, description);
		assertFalse(room.isBooked());
		room.setBooked();
		assertTrue(room.isBooked());
	}

	@Test
	public void testRemoveBooking() {
		String name = "N.323";
		int size = 30;
		String description = "This is a description!";

		Room room = new Room(size, name, description);
		room.setBooked();
		assertTrue(room.isBooked());

		room.removeBooking();
		assertFalse(room.isBooked());

	}

	@Test
	public void testRoomEquipment() {
		Room room = new Room(30, "N.321", "This is a description!");

		RoomEquipment eq1 = new RoomEquipment("Blackboard", 1);
		RoomEquipment eq2 = new RoomEquipment("Beamer", 2);

		List<RoomEquipment> testList = new ArrayList<RoomEquipment>();

		room.addEquipment(eq1);
		testList.add(eq1);
		assertEquals(testList, room.getEquipmentList());

		room.addEquipment(eq2);
		testList.add(eq2);
		assertEquals(testList, room.getEquipmentList());

		List<RoomEquipment> eqList = room.getEquipmentList();

		for (RoomEquipment eq : eqList) {
			if (eq.getName().equals("Beamer")) {
				room.removeEquipment(eq);
				break;
			}
		}
		testList.remove(eq2);

		assertEquals(testList, room.getEquipmentList());
	}
}
