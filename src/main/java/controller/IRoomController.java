/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller;

import java.util.List;

import srs.Room;

public interface IRoomController {
	/** Responsible for administrate the rooms */

	/**
	 * Add a new room and save it in list
	 * 
	 * @param roomName
	 *            all rooms saved in srs
	 * @param roomName
	 *            the room to be added
	 * @return List of rooms
	 */
	public List<Room> addRoom(Room roomName);

	/**
	 * Delete a room from list
	 * 
	 * @param roomName
	 *            all rooms saved in srs
	 * @param roomName
	 *            the room to be added
	 * @return list of rooms
	 */
	public List<Room> deleteRoom(String roomName);

	/**
	 * Edit a room
	 * 
	 * @param roomName
	 *            all rooms saved in srs
	 * @param roomName
	 *            the room to be added
	 */
	public void editRoom(String roomName);
}
