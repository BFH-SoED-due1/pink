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
	 * @param rooms
	 *            all rooms saved in srs
	 * @param roomName
	 *            the room to be added
	 */
	public void addRoom(List<Room> rooms, Room roomName);

	/**
	 * Delete a room from list
	 * 
	 * @param rooms
	 *            all rooms saved in srs
	 * @param roomName
	 *            the room to be added
	 */
	public void deleteRoom(List<Room> rooms, String roomName);

	/**
	 * Edit a room
	 * 
	 * @param rooms
	 *            all rooms saved in srs
	 * @param roomName
	 *            the room to be added
	 */
	public void editRoom(List<Room> rooms, String roomName);

	/**
	 * Control the room's name, its mostly not possible to have two rooms with
	 * the same name
	 * 
	 * @param rooms
	 *            all rooms saved in srs
	 * @param roomName
	 *            all rooms saved in srs
	 * @return true if a room with the desired name already exits
	 */
	public boolean checkRoomName(List<Room> rooms, String roomName);
}
