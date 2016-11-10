/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.util.ArrayList;
import java.util.List;

import controller.IRoomController;
import controller.exceptions.RoomNotFoundException;
import srs.Room;

public class RoomController implements IRoomController {
	/** Implementation for administrate the rooms */

	List<Room> roomList = new ArrayList();

	public RoomController(List<Room> roomList) {
		this.roomList = roomList;
	}

	@Override
	public List<Room> addRoom(Room room) {
		if (!exists(room.getName()) && notEmpty(room.getSize(), room.getDescription()))

			return roomList;
		return roomList;
	}

	@Override
	public List<Room> deleteRoom(String roomName) {
		return roomList;
		// TODO Auto-generated method stub

	}

	@Override
	public void editRoom(String roomName) {
		// TODO Auto-generated method stub

	}

	public boolean exists(String roomName) {
		boolean exists = false;
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getName().equals(roomName)) {
				exists = true;
				break;
			}
		}
		if (!exists)
			throw new RoomNotFoundException("Room does not exist!");

		return exists;
	}

	public boolean existsForNewRoom(String roomName) {
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getName().equals(roomName))
				return true;
		}
		return false;
	}

	/**
	 * @param size
	 * @param description
	 * @return
	 */
	private boolean notEmpty(int size, String description) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkRoomName(String roomName) {
		// TODO Auto-generated method stub
		return false;
	}

}
