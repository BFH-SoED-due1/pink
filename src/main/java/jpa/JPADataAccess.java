/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.due1.time.TimeSlot;
import data.DataAccess;

public class JPADataAccess extends DataAccess {
	private EntityManager entityManager;

	public JPADataAccess() {
		this.entityManager = Persistence.createEntityManagerFactory("srs-pu").createEntityManager();
	}

	///////////////////////// Booker /////////////////////////
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
	@Override
	public Booker registerBooker(String firstName, String lastName, String email) {
		this.entityManager.getTransaction().begin();
		Booker booker = new Booker(firstName, lastName, email);
		this.entityManager.persist(booker);
		this.entityManager.getTransaction().commit();
		return booker;
	}

	/**
	 * Gets all Bookers from DB
	 * @return List of Bookers
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Booker> getAllBookers() {
		Query query = this.entityManager.createQuery("select b from Booker b");
		return query.getResultList();
	}

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
	@Override
	public Booker editBooker(String firstName, String lastName, Long id) {
		this.entityManager.getTransaction().begin();
		Booker booker = this.entityManager.find(Booker.class, id);
		booker.setFirstName(firstName);
		booker.setLastName(lastName);
		this.entityManager.merge(booker);
		this.entityManager.getTransaction().commit();
		return booker;
	}

	/**
	 * Delets Booker from DB
	 * @param id
	 *            the Booker's id
	 */
	@Override
	public void deleteBooker(Long id) {
		this.entityManager.getTransaction().begin();
		Booker booker = this.entityManager.find(Booker.class, id);
		this.entityManager.remove(booker);
		this.entityManager.getTransaction().commit();
	}

	///////////////////////// Room /////////////////////////
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
	@Override
	public Room insertRoom(int size, String name, String descr) {
		this.entityManager.getTransaction().begin();
		Room room = new Room(size, name, descr);
		this.entityManager.persist(room);
		this.entityManager.getTransaction().commit();
		return room;
	}

	/**
	 * Gets all Rooms from DB
	 * @return List of Rooms
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getAllRooms() {
		Query query = this.entityManager.createQuery("select r from Room r");
		return query.getResultList();
	}

	/**
	 * Edits the Room's name and description
	 * @param size
	 *            the Room's size
	 * @param name
	 *            the Room's name
	 * @param description
	 *            the Room's description
	 * @return the inserted Room
	 */
	@Override
	public Room editRoom(int size, String name, String description, Long id) {
		this.entityManager.getTransaction().begin();
		Room room = this.entityManager.find(Room.class, id);
		room.setSize(size);
		room.setName(name);
		room.setDescription(description);
		this.entityManager.merge(room);
		this.entityManager.getTransaction().commit();
		return room;
	}

	/**
	 * Gets all Equipments from Room
	 * @return List of Equipments
	 */
	@Override
	public List<RoomEquipment> getAllEquipments(Long id) {
		this.entityManager.getTransaction().begin();
		Room room = this.entityManager.find(Room.class, id);
		return room.getEquipmentList();
	}

	/**
	 * Adds an equipment to the Room
	 * @param equipment
	 *            the new equipment
	 * @param id
	 *            the Room's id
	 * @return the Room
	 */
	@Override
	public Room addEquipment(RoomEquipment equipment, Long id) {
		this.entityManager.getTransaction().begin();
		Room room = this.entityManager.find(Room.class, id);
		room.addEquipment(equipment);
		this.entityManager.merge(room);
		this.entityManager.getTransaction().commit();
		return room;
	}

	/**
	 * Adds an equipment to the Room
	 * @param equipment
	 *            the new equipment
	 * @param id
	 *            the Room's id
	 * @return the Room
	 */
	@Override
	public Room removeEquipment(RoomEquipment equipment, Long id) {
		this.entityManager.getTransaction().begin();
		Room room = this.entityManager.find(Room.class, id);
		room.removeEquipment(equipment);
		this.entityManager.merge(room);
		this.entityManager.getTransaction().commit();
		return room;
	}

	/**
	 * Delets Room from DB
	 * @param id
	 *            the Room's id
	 */
	@Override
	public void deleteRoom(Long id) {
		this.entityManager.getTransaction().begin();
		Room room = this.entityManager.find(Room.class, id);
		this.entityManager.remove(room);
		this.entityManager.getTransaction().commit();
	}

	///////////////////////// SystemUser /////////////////////////
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
	@Override
	public SystemUser registerSystemUser(String firstName, String lastName, String email, String password, boolean isAdmin) {
		this.entityManager.getTransaction().begin();
		SystemUser user = new SystemUser(firstName, lastName, email, password, isAdmin);
		this.entityManager.persist(user);
		this.entityManager.getTransaction().commit();
		return user;
	}

	/**
	 * Gets all SystemUsers from DB
	 * @return List of SystemUsers
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemUser> getAllSystemUsers() {
		Query query = this.entityManager.createQuery("select u from SystemUser u");
		return query.getResultList();
	}

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
	@Override
	public SystemUser editSystemUser(String firstName, String lastName, String password, Long id) {
		this.entityManager.getTransaction().begin();
		SystemUser user = this.entityManager.find(SystemUser.class, id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		this.entityManager.merge(user);
		this.entityManager.getTransaction().commit();
		return user;
	}

	/**
	 * Delets SystemUser from DB
	 * @param id
	 *            the SystemUser's id
	 */
	@Override
	public void deleteSystemUser(Long id) {
		this.entityManager.getTransaction().begin();
		SystemUser user = this.entityManager.find(SystemUser.class, id);
		this.entityManager.remove(user);
		this.entityManager.getTransaction().commit();
	}

	///////////////////////// Reservation /////////////////////////
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
	@Override
	public Reservation insertReservation(Room room, TimeSlot timeSlot, Booker booker) {
		this.entityManager.getTransaction().begin();
		Reservation reservation = new Reservation(room, timeSlot, booker);
		this.entityManager.persist(reservation);
		this.entityManager.getTransaction().commit();
		return reservation;
	}

	/**
	 * Gets all Reservations from DB
	 * @return List of Reservations
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getAllReservations() {
		Query query = this.entityManager.createQuery("select r from Reservation r");
		return query.getResultList();
	}

	/**
	 * Delets Reservation from DB
	 * @param id
	 *            the Reservations's id
	 */
	@Override
	public void cancelReservation(Long id) {
		this.entityManager.getTransaction().begin();
		Reservation reservation = this.entityManager.find(Reservation.class, id);
		this.entityManager.remove(reservation);
		this.entityManager.getTransaction().commit();
	}
}
