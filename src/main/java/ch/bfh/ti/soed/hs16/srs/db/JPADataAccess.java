/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.due1.time.TimeSlot;
import ch.bfh.ti.soed.hs16.srs.model.Booker;
import ch.bfh.ti.soed.hs16.srs.model.IBooker;
import ch.bfh.ti.soed.hs16.srs.model.IReservation;
import ch.bfh.ti.soed.hs16.srs.model.IRoom;
import ch.bfh.ti.soed.hs16.srs.model.ISystemUser;
import ch.bfh.ti.soed.hs16.srs.model.Reservation;
import ch.bfh.ti.soed.hs16.srs.model.Room;
import ch.bfh.ti.soed.hs16.srs.model.RoomEquipment;
import ch.bfh.ti.soed.hs16.srs.model.SystemUser;

public class JPADataAccess extends DataAccess {
	private EntityManager entityManager;

	public JPADataAccess() {
		this.entityManager = Persistence.createEntityManagerFactory("srs-pu").createEntityManager();
	}

	///////////////////////// Booker /////////////////////////
	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@Override
	public Booker registerBooker(String firstName, String lastName, String email) {
		this.entityManager.getTransaction().begin();
		Booker booker = new Booker(firstName, lastName, email);
		this.entityManager.persist(booker);
		this.entityManager.getTransaction().commit();
		return booker;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IBooker> getAllBookers() {
		Query query = this.entityManager.createQuery("select b from Booker b");
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
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

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@Override
	public void deleteBooker(Long id) {
		this.entityManager.getTransaction().begin();
		Booker booker = this.entityManager.find(Booker.class, id);
		this.entityManager.remove(booker);
		this.entityManager.getTransaction().commit();
	}

	///////////////////////// Room /////////////////////////

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@Override
	public Room insertRoom(int size, String name, String descr) {
		this.entityManager.getTransaction().begin();
		Room room = new Room(size, name, descr);
		this.entityManager.persist(room);
		this.entityManager.getTransaction().commit();
		return room;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IRoom> getAllRooms() {
		Query query = this.entityManager.createQuery("select r from Room r");
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
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

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@Override
	public List<RoomEquipment> getAllEquipments(Long id) {
		this.entityManager.getTransaction().begin();
		Room room = this.entityManager.find(Room.class, id);
		this.entityManager.getTransaction().commit();
		return room.getEquipmentList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
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

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
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

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@Override
	public void deleteRoom(Long id) {
		this.entityManager.getTransaction().begin();
		Room room = this.entityManager.find(Room.class, id);
		this.entityManager.remove(room);
		this.entityManager.getTransaction().commit();
	}

	///////////////////////// RoomEquipment /////////////////////////
	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#insertRoomEquipment(java.lang.String, int)
	 */
	@Override
	public RoomEquipment insertRoomEquipment(String name, int qty) {
		this.entityManager.getTransaction().begin();
		RoomEquipment roomEquipmen = new RoomEquipment(name, qty);
		this.entityManager.persist(roomEquipmen);
		this.entityManager.getTransaction().commit();
		return roomEquipmen;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomEquipment> getAllRoomEquipments() {
		Query query = this.entityManager.createQuery("select re from RoomEquipment re");
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#editRoomEquipment(java.lang.String, int,
	 * java.lang.Long)
	 */
	@Override
	public RoomEquipment editRoomEquipment(int qty, Long id) {
		this.entityManager.getTransaction().begin();
		RoomEquipment roomEquipmen = this.entityManager.find(RoomEquipment.class, id);
		roomEquipmen.setQuantity(qty);
		this.entityManager.merge(roomEquipmen);
		this.entityManager.getTransaction().commit();
		return roomEquipmen;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#deleteRoomRoomEquipment(java.lang.Long)
	 */
	@Override
	public void deleteRoomRoomEquipment(Long id) {
		this.entityManager.getTransaction().begin();
		RoomEquipment roomEquipmen = this.entityManager.find(RoomEquipment.class, id);
		this.entityManager.remove(roomEquipmen);
		this.entityManager.getTransaction().commit();
	}

	///////////////////////// SystemUser /////////////////////////
	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@Override
	public SystemUser registerSystemUser(String firstName, String lastName, String email, String password,
			boolean isAdmin) {
		this.entityManager.getTransaction().begin();
		SystemUser user = new SystemUser(firstName, lastName, email, password, isAdmin);
		this.entityManager.persist(user);
		this.entityManager.getTransaction().commit();
		return user;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ISystemUser> getAllSystemUsers() {
		Query query = this.entityManager.createQuery("select u from SystemUser u");
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
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

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@Override
	public void deleteSystemUser(Long id) {
		this.entityManager.getTransaction().begin();
		SystemUser user = this.entityManager.find(SystemUser.class, id);
		this.entityManager.remove(user);
		this.entityManager.getTransaction().commit();
	}

	///////////////////////// Reservation /////////////////////////
	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@Override
	public IReservation insertReservation(IRoom room, TimeSlot timeSlot, IBooker booker) {
		this.entityManager.getTransaction().begin();
		Reservation reservation = new Reservation(room, timeSlot, booker);
		this.entityManager.persist(reservation);
		this.entityManager.getTransaction().commit();
		return reservation;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IReservation> getAllReservations() {
		Query query = this.entityManager.createQuery("select r from Reservation r");
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see data.DataAccess#cancelReservation(java.lang.Long)
	 */
	@Override
	public void cancelReservation(Long id) {
		this.entityManager.getTransaction().begin();
		Reservation reservation = this.entityManager.find(Reservation.class, id);
		this.entityManager.remove(reservation);
		this.entityManager.getTransaction().commit();
	}
}
