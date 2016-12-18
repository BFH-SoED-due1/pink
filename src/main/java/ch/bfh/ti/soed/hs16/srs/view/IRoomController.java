/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view;

import java.util.List;

import ch.bfh.ti.soed.hs16.srs.model.IRoom;

public interface IRoomController {
	/** Responsible for administrate the rooms */

	/**
	 * Add a new room and save it in list
	 * @param roomName all rooms saved in srs
	 * @param roomName the room to be added
	 * @return List of rooms
	 */
	public List<IRoom> addRoom(IRoom roomName);

	/**
	 * Delete a room from list
	 * @param roomName all rooms saved in srs
	 * @param roomName the room to be added
	 * @return list of rooms
	 */
	public List<IRoom> deleteRoom(String roomName);

	/**
	 * Edit a room
	 * @param size size of the room
	 * @param descr description of the room
	 * @param room the room object
	 */
	public void editRoom(int size, String descr, IRoom room);
}
