/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package data;

import java.util.List;

import ch.bfh.due1.time.TimeSlot;
import jpa.Booker;
import jpa.Reservation;
import jpa.Room;
import jpa.RoomEquipment;
import jpa.SystemUser;

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
				ex.printStackTrace();
				System.err.println("Could not load class: " + DATA_ACCESS_CLASS);
				throw new RuntimeException("Could not load class: " + DATA_ACCESS_CLASS);
			}
		}
		return instance;
	}

	// Methods for bookers
	public abstract Booker registerBooker(String firstName, String lastName, String email);

	public abstract List<Booker> getAllBookers();

	public abstract Booker editBooker(String firstName, String lastName, Long id);

	public abstract void deleteBooker(Long id);

	// Methods for rooms
	public abstract Room insertRoom(int size, String name, String descr);

	public abstract List<Room> getAllRooms();

	public abstract Room editRoom(int size, String name, String Description, Long id);

	public abstract List<RoomEquipment> getAllEquipments(Long id);

	public abstract Room addEquipment(RoomEquipment equipment, Long id);

	public abstract Room removeEquipment(RoomEquipment equipment, Long id);

	public abstract void deleteRoom(Long id);

	// Methods for systemUser
	public abstract SystemUser registerSystemUser(String firstName, String lastName, String email, String password, boolean isAdmin);

	public abstract List<SystemUser> getAllSystemUsers();

	public abstract SystemUser editSystemUser(String firstName, String lastName, String password, Long id);

	public abstract void deleteSystemUser(Long id);

	// Methods for reservations
	public abstract Reservation insertReservation(Room room, TimeSlot timeSlot, Booker booker);

	public abstract List<Reservation> getAllReservations();

	public abstract void cancelReservation(Long id);

}
