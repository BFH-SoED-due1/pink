/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import control.ARoom;
import control.RoomController;
import model.Room;

public class RoomControllerTest {

	@Test
	public void addRoomTest() {
		ARoom room = new Room(24, "321", "Classroom");

		List<ARoom> list = new ArrayList<ARoom>();
		// List<Room> expectedList = new ArrayList<Room>();

		RoomController rc = new RoomController(list);

		list = rc.addRoom(room);

		assertTrue(list.contains(room));
		// expectedList.add((Room) room);
		//
		// assertEquals(expectedList, list);
	}

	// @Test(expected = IllegalArgumentException.class)
	// public void addMinusSizeRoomTest() {
	// Room room = new Room(-1, "321", "Classroom");
	//
	// List<Room> list = new ArrayList<Room>();
	// List<Room> expectedList = new ArrayList<Room>();
	//
	// RoomController rc = new RoomController(list);
	//
	// list = rc.addRoom(room);
	// expectedList.add(room);
	//
	// assertEquals(expectedList, list);
	// }
	//
	// @Test(expected = RoomNameException.class)
	// public void addRoomTwiceTest() {
	// Room room = new Room(24, "321", "Classroom");
	//
	// List<Room> list = new ArrayList<Room>();
	//
	// RoomController rc = new RoomController(list);
	//
	// list = rc.addRoom(room);
	// list = rc.addRoom(room);
	// }
	//
	// @Test(expected = IllegalArgumentException.class)
	// public void addEmptyRoomTest() {
	// Room room = new Room(0, "", "");
	//
	// List<Room> list = new ArrayList<Room>();
	//
	// RoomController rc = new RoomController(list);
	//
	// list = rc.addRoom(room);
	// }
	//
	// @Test
	// public void deleteRoomTest() {
	// Room room = new Room(24, "321", "Classroom");
	//
	// List<Room> list = new ArrayList<Room>();
	// List<Room> expectedList = new ArrayList<Room>();
	//
	// RoomController rc = new RoomController(list);
	//
	// list = rc.addRoom(room);
	// expectedList.add(room);
	//
	// list = rc.deleteRoom(room.getName());
	// expectedList.remove(room);
	//
	// assertEquals(expectedList, list);
	// }
	//
	// @Test(expected = RoomNotFoundException.class)
	// public void deleteNotExistingRoomTest() {
	// Room room = new Room(24, "321", "Classroom");
	// Room room2 = new Room(24, "399", "Classroom");
	//
	// List<Room> list = new ArrayList<Room>();
	// List<Room> expectedList = new ArrayList<Room>();
	//
	// RoomController rc = new RoomController(list);
	//
	// list = rc.addRoom(room);
	// expectedList.add(room);
	//
	// list = rc.deleteRoom(room2.getName());
	// }
	//
	// @Test(expected = RoomNotFoundException.class)
	// public void deleteEmptyRoomTest() {
	// Room room = new Room(24, "321", "Classroom");
	// Room room2 = new Room(2, "222", "");
	//
	// List<Room> list = new ArrayList<Room>();
	// List<Room> expectedList = new ArrayList<Room>();
	//
	// RoomController rc = new RoomController(list);
	//
	// list = rc.addRoom(room);
	// expectedList.add(room);
	//
	// list = rc.deleteRoom(room2.getName());
	// }
	//
	// @Test
	// public void editRoomTest() {
	// Room room = new Room(24, "321", "Classroom");
	// Room room2 = new Room(24, "322", "Classroom");
	//
	// List<Room> list = new ArrayList<Room>();
	//
	// RoomController rc = new RoomController(list);
	//
	// list = rc.addRoom(room);
	//
	// rc.editRoom(26, "Conferenceroom", room);
	// room2.setSize(26);
	// room2.setDescription("Conferenceroom");
	//
	// assertEquals(room2.getSize(), room.getSize());
	// assertEquals(room2.getDescription(), room.getDescription());
	// }
	//
	// @Test(expected = RoomNotFoundException.class)
	// public void editWrongRoomTest() {
	// Room room = new Room(24, "321", "Classroom");
	// Room room2 = new Room(24, "322", "Classroom");
	//
	// List<Room> list = new ArrayList<Room>();
	//
	// RoomController rc = new RoomController(list);
	//
	// list = rc.addRoom(room);
	//
	// rc.editRoom(26, "Conferenceroom", room2);
	// }
	//
	// @Test(expected = IllegalArgumentException.class)
	// public void editEmtyRoomTest() {
	// Room room = new Room(24, "321", "Classroom");
	//
	// List<Room> list = new ArrayList<Room>();
	//
	// RoomController rc = new RoomController(list);
	//
	// list = rc.addRoom(room);
	//
	// rc.editRoom(-1, "", room);
	// }
}
