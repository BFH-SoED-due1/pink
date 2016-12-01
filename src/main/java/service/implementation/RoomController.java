/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service.implementation;

import java.util.List;

import data.DataAccess;
import jpa.Room;
import service.IRoomController;
import service.implementation.exceptions.RoomNameException;
import service.implementation.exceptions.RoomNotFoundException;

public class RoomController implements IRoomController {
	/** Implementation for administrate the rooms */

	/**
	 * Adds a new room
	 * @param room
	 *            the new room object
	 * @return the list of rooms
	 */
	@Override
	public Room addRoom(int size, String name, String descr) {
		Room room;
		try {
			DataAccess dataAccess = DataAccess.getInstance();
			if (!roomExistsForNewRoom(name) && notEmpty(size, descr))
				room = dataAccess.insertRoom(size, name, descr);
			else
				throw new RoomNameException("A Room with this name allready exists.\nChose another name");
		} catch (Exception ex) {
			throw new RoomNameException("A Room with this name allready exists.\nChose another name");
		}
		return room;
	}

	/**
	 * Deletes a room
	 * @param roomName
	 *            the uniqe name of the room
	 * @return the list of room
	 */
	@Override
	public void deleteRoom(Room room) {
		try {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.deleteRoom(room.getId());
		} catch (Exception ex) {
			throw new RoomNotFoundException("No Room Found");
		}
	}

	/**
	 * Edit a room
	 * @param size
	 *            the size of the room
	 * @param descr
	 *            the description of the room
	 * @param r
	 *            the room object
	 */
	@Override
	public void editRoom(int size, String descr, Room room) {
		DataAccess dataAccess = DataAccess.getInstance();
		if (roomExists(room.getName()) && notEmpty(size, descr)) {
			dataAccess.editRoom(size, room.getName(), descr, room.getId());
		}
	}

	/**
	 * Checks if a room exists
	 * @param roomName
	 *            the uniqe name of the room
	 * @return true if room exists
	 */
	public boolean roomExists(String roomName) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<Room> roomList = dataAccess.getAllRooms();
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

	/**
	 * Checks if a room exists. Only used for save a new room
	 * @param roomName
	 *            the uniqe name of the room
	 * @return true if room exists
	 */
	public boolean roomExistsForNewRoom(String roomName) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<Room> roomList = dataAccess.getAllRooms();
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getName().equals(roomName))
				return true;
		}
		return false;
	}

	/**
	 * Checks if the size or the description are not empty
	 * @param size
	 *            the rooms size
	 * @param description
	 *            the roooms description
	 * @return true if size and description are not empty
	 */
	private boolean notEmpty(int size, String description) {
		boolean notEmpty = true;
		if (size <= 0 || description.isEmpty())
			notEmpty = false;
		if (!notEmpty)
			throw new IllegalArgumentException("Input is empty! Size have to be greater than 0!");
		return notEmpty;
	}

	/**
	 * Gets all Rooms
	 * @return List of Rooms
	 */
	@Override
	public List<Room> getAllRooms() {
		DataAccess dataAccess = DataAccess.getInstance();
		return dataAccess.getAllRooms();
	}
}
