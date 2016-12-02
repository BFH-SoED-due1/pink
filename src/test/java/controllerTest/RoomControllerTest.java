/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import control.ARoom;
import control.RoomController;
import control.exceptions.RoomNameException;
import control.exceptions.RoomNotFoundException;
import model.Room;

public class RoomControllerTest {

	@Test
	public void addRoomTest() {
		ARoom room = new Room(24, "321", "Classroom");
		List<ARoom> list = new ArrayList<ARoom>();
		RoomController ctrl = new RoomController(list);

		list = ctrl.addRoom(room);
		assertTrue(list.contains(room));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addMinusSizeRoomTest() {
		Room room = new Room(-1, "321", "Classroom");
		List<ARoom> list = new ArrayList<ARoom>();
		List<ARoom> expectedList = new ArrayList<ARoom>();
		RoomController ctrl = new RoomController(list);

		list = ctrl.addRoom(room);
		expectedList.add(room);

		assertEquals(expectedList, list);
	}

	@Test(expected = RoomNameException.class)
	public void addRoomTwiceTest() {
		ARoom room = new Room(24, "321", "Classroom");
		List<ARoom> list = new ArrayList<ARoom>();
		RoomController ctrl = new RoomController(list);

		list = ctrl.addRoom(room);
		list = ctrl.addRoom(room);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addEmptyRoomTest() {
		ARoom room = new Room(0, "", "");
		List<ARoom> list = new ArrayList<ARoom>();
		RoomController ctrl = new RoomController(list);

		list = ctrl.addRoom(room);
	}

	@Test
	public void deleteRoomTest() {
		ARoom room = new Room(24, "321", "Classroom");
		List<ARoom> list = new ArrayList<ARoom>();
		List<ARoom> expectedList = new ArrayList<ARoom>();
		RoomController ctrl = new RoomController(list);

		list = ctrl.addRoom(room);
		expectedList.add(room);

		list = ctrl.deleteRoom(room.getName());
		expectedList.remove(room);

		assertEquals(expectedList, list);
	}

	@Test(expected = RoomNotFoundException.class)
	public void deleteNotExistingRoomTest() {
		ARoom room = new Room(24, "321", "Classroom");
		ARoom room2 = new Room(24, "399", "Classroom");

		List<ARoom> list = new ArrayList<ARoom>();
		List<ARoom> expectedList = new ArrayList<ARoom>();
		RoomController rc = new RoomController(list);

		list = rc.addRoom(room);
		expectedList.add(room);

		list = rc.deleteRoom(room2.getName());
	}

	@Test(expected = RoomNotFoundException.class)
	public void deleteEmptyRoomTest() {
		ARoom room = new Room(24, "321", "Classroom");
		ARoom room2 = new Room(2, "222", "");
		List<ARoom> list = new ArrayList<ARoom>();
		List<ARoom> expectedList = new ArrayList<ARoom>();
		RoomController ctrl = new RoomController(list);

		list = ctrl.addRoom(room);
		expectedList.add(room);

		list = ctrl.deleteRoom(room2.getName());
	}

	@Test
	public void editRoomTest() {
		ARoom room = new Room(24, "321", "Classroom");
		ARoom room2 = new Room(24, "322", "Classroom");
		List<ARoom> list = new ArrayList<ARoom>();
		RoomController ctrl = new RoomController(list);

		list = ctrl.addRoom(room);
		ctrl.editRoom(26, "Conferenceroom", room);
		room2.setSize(26);
		room2.setDescription("Conferenceroom");

		assertEquals(room2.getSize(), room.getSize());
		assertEquals(room2.getDescription(), room.getDescription());
	}

	@Test(expected = RoomNotFoundException.class)
	public void editWrongRoomTest() {
		ARoom room = new Room(24, "321", "Classroom");
		ARoom room2 = new Room(24, "322", "Classroom");
		List<ARoom> list = new ArrayList<ARoom>();
		RoomController ctrl = new RoomController(list);

		list = ctrl.addRoom(room);
		ctrl.editRoom(26, "Conferenceroom", room2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void editEmtyRoomTest() {
		ARoom room = new Room(24, "321", "Classroom");
		List<ARoom> list = new ArrayList<ARoom>();
		RoomController ctrl = new RoomController(list);

		list = ctrl.addRoom(room);
		ctrl.editRoom(-1, "", room);
	}
}
