/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.controller.RoomController;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.RoomNameException;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.RoomNotFoundException;
import ch.bfh.ti.soed.hs16.srs.model.Room;
import ch.bfh.ti.soed.hs16.srs.srsSurface.IRoom;

public class RoomControllerTest {
	private RoomController roomController;

	@Before
	public void setUp() {
		this.roomController = new RoomController();
	}

	@Test
	public void addRoomTest() {
		String name = "111";
		int size = 24;
		String descr = "Classroom";

		this.roomController.addRoom(size, name, descr);
		List<IRoom> rooms = this.roomController.listAllRooms();

		assertNotNull(rooms);
		assertTrue(rooms.size() >= 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addMinusSizeRoomTest() {
		String name = "112";
		int size = -1;
		String descr = "Classroom";

		this.roomController.addRoom(size, name, descr);
	}

	@Test(expected = RoomNameException.class)
	public void addRoomTwiceTest() {
		String name = "113";
		int size = 24;
		String descr = "Classroom";

		this.roomController.addRoom(size, name, descr);
		this.roomController.addRoom(size, name, descr);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addEmptyRoomTest() {
		String name = "";
		int size = 0;
		String descr = "";

		this.roomController.addRoom(size, name, descr);
	}

	@Test
	public void deleteRoomTest() {
		String name = "114";
		int size = 24;
		String descr = "Classroom";

		this.roomController.addRoom(size, name, descr);
		List<IRoom> rooms = this.roomController.listAllRooms();

		assertNotNull(rooms);
		assertTrue(rooms.size() >= 0);

		IRoom r = this.roomController.getRoomByName(name);

		this.roomController.deleteRoom(r);

		rooms = this.roomController.listAllRooms();
		assertFalse(rooms.contains(r));
	}

	@Test(expected = RoomNotFoundException.class)
	public void deleteNotExistingRoomTest() {
		IRoom room = new Room(24, "399", "Classroom");

		this.roomController.deleteRoom(room);
	}

	@Test
	public void editRoomTest() {
		String name = "116";
		int size = 24;
		String descr = "Classroom";

		this.roomController.addRoom(size, name, descr);
		List<IRoom> rooms = this.roomController.listAllRooms();

		assertNotNull(rooms);
		assertTrue(rooms.size() >= 0);

		IRoom r = this.roomController.getRoomByName(name);
		int newSize = 28;
		String newDescr = "Conference room";

		this.roomController.editRoom(newSize, newDescr, r);

		assertEquals(newSize, r.getSize());
		assertEquals(newDescr, r.getDescription());
	}

	@Test(expected = RoomNotFoundException.class)
	public void editWrongRoomTest() {
		String name = "117";
		int size = 24;
		String descr = "Classroom";

		IRoom room = new Room(24, "499", "Classroom");

		this.roomController.addRoom(size, name, descr);

		this.roomController.editRoom(29, "Classroom", room);
	}

	@Test(expected = RoomNotFoundException.class)
	public void getWrongRoomByNameTest() {
		this.roomController.getRoomByName("999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void editEmtyRoomTest() {
		String name = "118";
		int size = 24;
		String descr = "Classroom";

		IRoom room = new Room(24, "599", "Classroom");

		this.roomController.addRoom(size, name, descr);

		this.roomController.editRoom(-1, "", room);
	}
}
