/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package db;

import java.util.List;

import ch.bfh.due1.time.TimeSlot;
import model.Booker;
import model.Reservation;
import model.Room;
import model.RoomEquipment;
import model.SystemUser;

public abstract class DataAccess {

	public static final String DATA_ACCESS_CLASS = "model.JPADataAccess";

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
	/**
	 * Inserts Booker into DB
	 * @param firstName
	 *            the Booker's firstname
	 * @param lastName
	 *            the Booker's lastname
	 * @param email
	 *            the Booker's email
	 * @return the inserted Booker
	 */
	public abstract Booker registerBooker(String firstName, String lastName, String email);

	/**
	 * Gets all Bookers from DB
	 * @return List of Bookers
	 */
	public abstract List<Booker> getAllBookers();

	/**
	 * Edits the Room's name and description
	 *
	 * @param firstName
	 *            the Booker's new firstname
	 * @param lastName
	 *            the Booker's new lastname
	 * @param id
	 *            the Booker's id
	 * @return the inserted Booker
	 */
	public abstract Booker editBooker(String firstName, String lastName, Long id);

	/**
	 * Delets Booker from DB
	 *
	 * @param id
	 *            the Booker's id
	 */
	public abstract void deleteBooker(Long id);

	// Methods for rooms
	/**
	 * Inserts Room into DB
	 * @param size
	 *            the Room's size
	 * @param name
	 *            the Room's name
	 * @param descr
	 *            the Room's description
	 * @return the inserted Room
	 */
	public abstract Room insertRoom(int size, String name, String descr);

	/**
	 * Gets all Rooms from DB
	 * @return List of Rooms
	 */
	public abstract List<Room> getAllRooms();

	/**
	 * Edits the Room's name and description
	 * @param size
	 *            the Room's size
	 * @param name
	 *            the Room's name
	 * @param description
	 *            the Room's description
	 * @param id
	 *            the Room's id
	 * @return the inserted Room
	 */
	public abstract Room editRoom(int size, String name, String description, Long id);

	/**
	 * Gets all Equipments from Room
	 * @return List of Equipments
	 */
	public abstract List<RoomEquipment> getAllEquipments(Long id);

	/**
	 * Adds an equipment to the Room
	 * @param equipment
	 *            the new equipment
	 * @param id
	 *            the Room's id
	 * @return the Room
	 */
	public abstract Room addEquipment(RoomEquipment equipment, Long id);

	/**
	 * Adds an equipment to the Room
	 * @param equipment
	 *            the new equipment
	 * @param id
	 *            the Room's id
	 * @return the Room
	 */
	public abstract Room removeEquipment(RoomEquipment equipment, Long id);

	/**
	 * Delets Room from DB
	 * @param id
	 *            the Room's id
	 */
	public abstract void deleteRoom(Long id);

	// Methods for roomEquipment
	/**
	 * Inserts Room into DB
	 * @param name
	 *            the Eqiupment's name
	 * @param qty
	 *            the Eqiupment's quantity
	 * @return the inserted Eqiupment
	 */
	public abstract RoomEquipment insertRoomEquipment(String name, int qty);

	/**
	 * Gets all Rooms from DB
	 * @return List of Rooms
	 */
	public abstract List<RoomEquipment> getAllRoomEquipments();

	/**
	 * Edits the Room's name and description
	 * @param qty
	 *            the Eqiupment's quantity
	 * @param id
	 *            the Eqiupment's id
	 * @return the inserted Eqiupment
	 */
	public abstract RoomEquipment editRoomEquipment(int qty, Long id);

	/**
	 * Delets Room from DB
	 * @param id
	 *            the Eqiupment's id
	 */
	public abstract void deleteRoomRoomEquipment(Long id);

	// Methods for systemUser
	/**
	 * Inserts SystemUser into DB
	 * @param firstName
	 *            the SystemUser's firstname
	 * @param lastName
	 *            the SystemUser's lastname
	 * @param email
	 *            the SystemUser's email
	 * @param password
	 *            the SystemUser's password
	 * @param isAdmin
	 *            true if User is Admin
	 * @return the inserted SystemUser
	 */
	public abstract SystemUser registerSystemUser(String firstName, String lastName, String email, String password, boolean isAdmin);

	/**
	 * Gets all SystemUsers from DB
	 * @return List of SystemUsers
	 */
	public abstract List<SystemUser> getAllSystemUsers();

	/**
	 * Edits the Users's name and description
	 * @param firstName
	 *            the Users's new firstname
	 * @param lastName
	 *            the Users's new lastname
	 * @param password
	 *            the Users's new password
	 * @param id
	 *            the Users's id
	 * @return the Users
	 */
	public abstract SystemUser editSystemUser(String firstName, String lastName, String password, Long id);

	/**
	 * Delets SystemUser from DB
	 * @param id
	 *            the SystemUser's id
	 */
	public abstract void deleteSystemUser(Long id);

	// Methods for reservations
	/**
	 * Inserts Reservation into DB
	 * @param room
	 *            the reserved room
	 * @param timeSlot
	 *            the time slot of the reservation
	 * @param booker
	 *            the booker who reservs
	 * @return the inserted Reservation
	 */
	public abstract Reservation insertReservation(Room room, TimeSlot timeSlot, Booker booker);

	/**
	 * Gets all Reservations from DB
	 * @return List of Reservations
	 */
	public abstract List<Reservation> getAllReservations();

	/**
	 * Delets Reservation from DB
	 * @param id
	 *            the Reservations's id
	 */
	public abstract void cancelReservation(Long id);

}
