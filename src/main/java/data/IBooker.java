/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package data;

import java.util.List;

import jpa.Booker;
import jpa.Reservation;

/**
 * @author Nathalie
 *
 */
public interface IBooker {

	/**
	 * set Booker's firstname
	 * @param firstName
	 *            the Bookers firstname
	 */
	public void setFirstName(String firstName);

	/**
	 * set Bookers lastname
	 * @param lastName
	 *            the Bookers lastname
	 */
	public void setLastName(String lastName);

	/**
	 * set Bookers email
	 * @param email
	 *            the BBookers email
	 */
	public void setLogin(String email);

	/**
	 * get the Booker
	 * @return Booker
	 */
	@Override
	public String toString();

	/**
	 * get the Booker's firstname
	 * @return the Booker's firstname
	 */
	public String getFirstName();

	/**
	 * get the Booker's lastname
	 * @return the Booker's lastname
	 */
	public String getLastName();

	/**
	 * get the Booker's email
	 * @return the Booker's email
	 */
	public String getLogin();

	/**
	 * get the Booker object
	 * @return the Booker object
	 */
	public Booker getBooker();

	/**
	 * get the Booker's Reservation list
	 * @return the List of Reservations
	 */
	public List<Reservation> getReservations();

	/**
	 * add a Reservation
	 * @param reservation
	 *            the Reservation
	 */
	public void addReservation(Reservation reservation);

	/**
	 * remove a Reservation
	 * @param reservation
	 *            the Reservation
	 */
	public void removeReservation(Reservation reservation);
}
