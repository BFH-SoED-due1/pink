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
	 * Add a new room
	 * @param size
	 *            the Room's size
	 * @param name
	 *            the Room's name
	 * @param descr
	 *            the Room's description
	 */
	public void addRoom(int size, String name, String descr);

	/**
	 * Delete a room from list
	 * @param room
	 *            the room to delete
	 */
	public void deleteRoom(IRoom room);

	/**
	 * get a list of all rooms
	 * @return list of rooms
	 */
	public List<IRoom> listAllRooms();

	/**
	 * get roome by name
	 * @param name
	 *            the Room's name
	 * @return room
	 */
	public IRoom getRoomByName(String name);

	/**
	 * Edit a room
	 * @param size
	 *            size of the room
	 * @param descr
	 *            description of the room
	 * @param room
	 *            the room object
	 */
	public void editRoom(int size, String descr, IRoom room);
}
