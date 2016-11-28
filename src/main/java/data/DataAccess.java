/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package data;

import java.util.List;

import jpa.Booker;
import jpa.Room;

public abstract class DataAccess {

	public static final String DATA_ACCESS_CLASS = "jpa.JPADataAccess";

	private static DataAccess instance = null;

	public static DataAccess getInstance() {
		// The following is NOT thread safe:
		if (instance == null) {
			try {
				@SuppressWarnings("rawtypes")
				Class clazz = Class.forName(DATA_ACCESS_CLASS);
				instance = (DataAccess) clazz.newInstance();
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.err.println("Could not load class: " + DATA_ACCESS_CLASS);
				throw new RuntimeException("Could not load class: " + DATA_ACCESS_CLASS);
			}
		}
		return instance;
	}

	// Methods for bookers
	public abstract Booker registerBooker(String firstName, String lastName, String email);

	public abstract List<Booker> getAllBookers();

	public abstract void deleteBooker(Long id);

	// Methods for rooms
	public abstract Room insertRoom(String name, int capacity);

	public abstract List<Room> findAllRooms();

	public abstract void deleteRoom(Long id);

	// Methods for systemUser
}
