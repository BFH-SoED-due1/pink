/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jpa.Room;
import service.implementation.RoomController;
import service.implementation.exceptions.RoomNameException;
import service.implementation.exceptions.RoomNotFoundException;

public class RoomControllerTest {
	private RoomController roomController;

	@Before
	public void setUp() {
		this.roomController = new RoomController();
	}

	@Test
	public void addRoomTest() {
		Room room = roomController.addRoom(24, "320", "Classroom");

		List<Room> list = roomController.getAllRooms();

		assertTrue(list.contains(room));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addMinusSizeRoomTest() {
		Room room = roomController.addRoom(-1, "321", "Classroom");

		List<Room> list = roomController.getAllRooms();

		assertTrue(list.contains(room));
	}

	@Test(expected = RoomNameException.class)
	public void addRoomTwiceTest() {
		roomController.addRoom(24, "322", "Classroom");
		roomController.addRoom(24, "322", "Classroom");
	}

	@Test(expected = IllegalArgumentException.class)
	public void addEmptyRoomTest() {
		Room room = roomController.addRoom(0, "", "");
	}

	@Test
	public void deleteRoomTest() {
		Room room = roomController.addRoom(24, "333", "Classroom");

		roomController.deleteRoom(room);

		List<Room> list = roomController.getAllRooms();

		assertFalse(list.contains(room));
	}

	@Test(expected = RoomNotFoundException.class)
	public void deleteNotExistingRoomTest() {
		Room room = new Room(24, "324", "Classroom");

		roomController.deleteRoom(room);
	}

	@Test(expected = RoomNotFoundException.class)
	public void deleteEmptyRoomTest() {
		Room room = new Room(0, "", "");

		roomController.deleteRoom(room);
	}

	@Test
	public void editRoomTest() {
		Room room = roomController.addRoom(24, "325", "Classroom");

		int newSize = 28;
		String newDescr = "Conference room";

		roomController.editRoom(newSize, newDescr, room);

		assertEquals(newSize, room.getSize());
		assertEquals(newDescr, room.getDescription());
	}

	@Test(expected = RoomNotFoundException.class)
	public void editWrongRoomTest() {
		Room room = roomController.addRoom(24, "326", "Classroom");
		Room room2 = new Room(24, "398", "Classroom");

		roomController.editRoom(25, "Test", room2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void editEmtyRoomTest() {
		Room room = roomController.addRoom(24, "327", "Classroom");

		roomController.editRoom(-1, "", room);
	}
}
