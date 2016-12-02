/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package model;

public abstract class ARoom {
	/**
	 * set room size
	 * @param s
	 *            the size of the room
	 */
	public abstract void setSize(int s);

	/**
	 * set the room name
	 * @param n
	 *            the name of the room
	 */
	public abstract void setName(String n);

	/**
	 * set the description of the room
	 * @param d
	 *            the room description
	 */
	public abstract void setDescription(String d);

	/** true if the room is reservated */
	public abstract void setBooked();

	/** remove the booking */
	public abstract void removeBooking();

	/**
	 * get the size of the room
	 * @return the Room's size
	 */
	public abstract int getSize();

	/**
	 * get the name of th room
	 * @return the Room's name
	 */
	public abstract String getName();

	/**
	 * get the description of the room
	 * @return the Room's description
	 */
	public abstract String getDescription();

	/**
	 * returns true if room is booked
	 * @return true if Room is booked
	 */
	public abstract boolean isBooked();

}
