/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import controller.implementation.RoomController;
import srs.Room;

public class RoomControllerTest {

	@Test
	public void addRoomTest() {
		Room room = new Room(24, "321", "Classroom");

		List<Room> list = new ArrayList<Room>();
		List<Room> oldList = new ArrayList<Room>();

		RoomController rc = new RoomController(list);

		list = rc.addRoom(room);
		oldList.add(room);

		assertEquals(oldList, list);
	}

}
