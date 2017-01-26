/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.controller;

import java.util.List;

import ch.bfh.ti.soed.hs16.srs.controller.exceptions.RoomNameException;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.RoomNotFoundException;
import ch.bfh.ti.soed.hs16.srs.db.DataAccess;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoomController;

public class RoomController implements IRoomController {
	/** Implementation for administer the rooms */

	public RoomController() {
	}

	@Override
	public void addRoom(int size, String name, String descr) {
		if (!roomExistsForNewRoom(name) && notEmpty(size, descr)) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.insertRoom(size, name, descr);
		} else
			throw new RoomNameException("A Room with this name allready exists.\nChose another name");

	}

	@Override
	public void deleteRoom(IRoom room) {
		if (roomExists(room.getName())) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.deleteRoom(room.getId());
		}
	}

	@Override
	public List<IRoom> listAllRooms() {
		DataAccess dataAccess = DataAccess.getInstance();
		return dataAccess.getAllRooms();
	}

	@Override
	public IRoom getRoomByName(String name) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<IRoom> roomList = dataAccess.getAllRooms();
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getName().equals(name)) {
				return roomList.get(i);
			}
		}
		throw new RoomNotFoundException("Room does not exist!");
	}

	@Override
	public void editRoom(int size, String descr, IRoom r) {
		if (roomExists(r.getName()) && notEmpty(size, descr)) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.editRoom(size, r.getName(), descr, r.getId());
		}
	}

	/**
	 * Checks if a room exists
	 * 
	 * @param roomName
	 *            the uniqe name of the room
	 * @return true if room exists
	 */
	public boolean roomExists(String roomName) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<IRoom> roomList = dataAccess.getAllRooms();
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
	 * 
	 * @param roomName
	 *            the uniqe name of the room
	 * @return true if room exists
	 */
	public boolean roomExistsForNewRoom(String roomName) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<IRoom> roomList = dataAccess.getAllRooms();
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getName().equals(roomName))
				return true;
		}
		return false;
	}

	/**
	 * Checks if the size or the description are not empty
	 * 
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
}
