/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service.implementation;

import java.util.ArrayList;
import java.util.List;

import jpa.Room;
import service.IRoomController;
import service.implementation.exceptions.RoomNameException;
import service.implementation.exceptions.RoomNotFoundException;

public class RoomController implements IRoomController {
	/** Implementation for administrate the rooms */

	private List<Room> roomList = new ArrayList<Room>();

	public RoomController(List<Room> roomList) {
		this.roomList = roomList;
	}

	/**
	 * Adds a new room
	 * @param room the new room object
	 * @return the list of rooms
	 */
	@Override
	public List<Room> addRoom(Room room) {
		if (!roomExistsForNewRoom(room.getName()) && notEmpty(room.getSize(), room.getDescription()))
			roomList.add(room);
		else
			throw new RoomNameException("A Room with this name allready exists.\nChose another name");

		return roomList;
	}

	/**
	 * Deletes a room
	 * @param roomName the uniqe name of the room
	 * @return the list of room
	 */
	@Override
	public List<Room> deleteRoom(String roomName) {
		if (roomExists(roomName)) {
			for(int i=0; i<this.roomList.size(); i++) {
				if(this.roomList.get(i).getName().equals(roomName)) {
					this.roomList.remove(i);
					break;
				}
			}
		}
		return roomList;
	}

	/**
	 * Edit a room
	 * @param size the size of the room
	 * @param descr the description of the room
	 * @param r the room object
	 */
	@Override
	public void editRoom(int size, String descr, Room r) {
		if (roomExists(r.getName()) && notEmpty(size, descr)) {
			for(int i=0; i<this.roomList.size(); i++) {
				if(this.roomList.get(i).getName().equals(r.getName())) {
					this.roomList.get(i).setSize(size);
					this.roomList.get(i).setDescription(descr);
					break;
				}
			}
		}
	}

	/**
	 * Checks if a room exists
	 * @param roomName the uniqe name of the room
	 * @return true if room exists
	 */
	public boolean roomExists(String roomName) {
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
	 * @param roomName the uniqe name of the room
	 * @return true if room exists
	 */
	public boolean roomExistsForNewRoom(String roomName) {
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getName().equals(roomName))
				return true;
		}
		return false;
	}

	/**
	 * Checks if the size or the description are not empty
	 * @param size the rooms size
	 * @param description the roooms description
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
}
