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

import data.DataAccess;

public class JPADataAccess extends DataAccess {
	private EntityManager entityManager;

	public JPADataAccess() {
		this.entityManager = Persistence.createEntityManagerFactory("srs-pu").createEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.DataAccess#registerBooker(java.lang.String, java.lang.String)
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
	 * @see data.DataAccess#getAllBookers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Booker> getAllBookers() {
		Query query = this.entityManager.createQuery("select b from Booker b");
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.DataAccess#deleteBooker(java.lang.Long)
	 */
	@Override
	public void deleteBooker(Long id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.DataAccess#insertRoom(java.lang.String, int)
	 */
	@Override
	public Room insertRoom(String name, int capacity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.DataAccess#findAllRooms()
	 */
	@Override
	public List<Room> findAllRooms() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.DataAccess#deleteRoom(java.lang.Long)
	 */
	@Override
	public void deleteRoom(Long id) {
		// TODO Auto-generated method stub

	}
}
