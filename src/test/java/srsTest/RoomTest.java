/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package srsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jpa.Room;

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

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyRoomName() {
		String name = "";
		int size = 30;
		String description = "This is a description!";
		String newName = "N.522";

		Room room = new Room(size, name, description);
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

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeSize() {
		String name = "N.322";
		int size = -1;
		String description = "This is a description!";
		int newSize = 36;

		Room room = new Room(size, name, description);
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
}
