/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.db;

import java.util.List;

import ch.bfh.ti.soed.hs16.srs.model.RoomEquipment;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IReservation;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;
import ch.bfh.ti.soed.hs16.srs.srsInterface.ISystemUser;

public abstract class DataAccess {

	public static final String DATA_ACCESS_CLASS = "ch.bfh.ti.soed.hs16.srs.db.JPADataAccess";

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
	public abstract IBooker registerBooker(String firstName, String lastName, String email);

	/**
	 * Gets all Bookers from DB
	 * @return List of Bookers
	 */
	public abstract List<IBooker> getAllBookers();

	/**
	 * Edits the Room's name and description
	 * @param firstName
	 *            the Booker's new firstname
	 * @param lastName
	 *            the Booker's new lastname
	 * @param id
	 *            the Booker's id
	 * @return the inserted Booker
	 */
	public abstract IBooker editBooker(String firstName, String lastName, Long id);

	/**
	 * Delets Booker from DB
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
	public abstract IRoom insertRoom(int size, String name, String descr);

	/**
	 * Gets all Rooms from DB
	 * @return List of Rooms
	 */
	public abstract List<IRoom> getAllRooms();

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
	public abstract IRoom editRoom(int size, String name, String description, Long id);

	/**
	 * Gets all Equipments from Room
	 * @param id
	 *            the Room's id
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
	public abstract IRoom addEquipment(RoomEquipment equipment, Long id);

	/**
	 * Adds an equipment to the Room
	 * @param equipment
	 *            the new equipment
	 * @param id
	 *            the Room's id
	 * @return the Room
	 */
	public abstract IRoom removeEquipment(RoomEquipment equipment, Long id);

	/**
	 * Delets Room from DB
	 * @param id
	 *            the Room's id
	 */
	public abstract void deleteRoom(Long id);

	// Methods for roomEquipment
	/**
	 * Inserts Equipment into DB
	 * @param name
	 *            the Eqiupment's name
	 * @param qty
	 *            the Eqiupment's quantity
	 * @return the inserted Eqiupment
	 */
	public abstract RoomEquipment insertRoomEquipment(String name, int qty);

	/**
	 * Gets all Equipment from DB
	 * @return List of Rooms
	 */
	public abstract List<RoomEquipment> getAllRoomEquipments();

	/**
	 * Edits the Equipment's name and description
	 * @param qty
	 *            the Eqiupment's quantity
	 * @param id
	 *            the Eqiupment's id
	 * @return the inserted Eqiupment
	 */
	public abstract RoomEquipment editRoomEquipment(int qty, Long id);

	/**
	 * Delets Equipment from DB
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
	public abstract ISystemUser registerSystemUser(String firstName, String lastName, String email, String password,
			boolean isAdmin);

	/**
	 * Gets all SystemUsers from DB
	 * @return List of SystemUsers
	 */
	public abstract List<ISystemUser> getAllSystemUsers();

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
	 * @return all users
	 */
	public abstract ISystemUser editSystemUser(String firstName, String lastName, String password, Long id);

	/**
	 * Delets SystemUser from DB
	 * @param id
	 *            the SystemUser's id
	 */
	public abstract void deleteSystemUser(Long id);

	/**
	 * Sets the User's admin state
	 * @param isAdmin
	 *            the admin state
	 * @param id
	 *            the SystemUser's id
	 */
	public abstract void setUserAdmin(boolean isAdmin, Long id);

	// Methods for reservations
	/**
	 * Inserts Reservation into DB
	 * @param reservation
	 *            the reservation
	 * @return the inserted Reservation
	 */
	public abstract IReservation insertReservation(IReservation reservation);

	/**
	 * Gets all Reservations from DB
	 * @return List of Reservations
	 */
	public abstract List<IReservation> getAllReservations();

	/**
	 * Delets Reservation from DB
	 * @param id
	 *            the Reservations's id
	 */
	public abstract void cancelReservation(Long id);
}
