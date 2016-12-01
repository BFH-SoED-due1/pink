/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service;

import java.util.List;

import jpa.Room;

public interface IRoomController {
	/** Responsible for administrate the rooms */

	/**
	 * Add a new room and save it in list
	 * @param size
	 *            all Room's size
	 * @param name
	 *            the Room's name
	 * @param descr
	 *            the Rooms description
	 * @return the Room
	 */
	public Room addRoom(int size, String name, String descr);

	/**
	 * Delete a room from list
	 * @param room
	 *            the Room to delete
	 */
	public void deleteRoom(Room room);

	/**
	 * Edit a room
	 * @param size
	 *            size of the room
	 * @param descr
	 *            description of the room
	 * @param room
	 *            the room object
	 */
	public void editRoom(int size, String descr, Room room);

	/**
	 * @return list of rooms
	 */
	public List<Room> getAllRooms();
}
