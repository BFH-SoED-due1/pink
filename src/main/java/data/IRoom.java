/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package data;

import java.util.List;

import jpa.Reservation;

/**
 * @author Nathalie
 *
 */
public interface IRoom {
	/**
	 * set room size
	 * @param size
	 *            the size of the room
	 */
	public void setSize(int size);

	/**
	 * set the room name
	 * @param name
	 *            the name of the room
	 */
	public void setName(String name);

	/**
	 * set the description of the room
	 * @param descr
	 *            the room description
	 */
	public void setDescription(String descr);

	/**
	 * true if the room is reservated
	 */
	public void setBooked();

	/**
	 * remove the booking
	 */
	public void removeBooking();

	/**
	 * get the size of the Room
	 * @return Room's size
	 */
	public int getSize();

	/**
	 * get the name of the Room
	 * @return Room's name
	 */
	public String getName();

	/**
	 * get the description of the Room
	 * @return Room's description
	 */
	public String getDescription();

	/**
	 * true if room is booked
	 * @return Room's booked state
	 */
	public boolean isBooked();

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
