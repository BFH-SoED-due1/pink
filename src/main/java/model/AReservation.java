/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package model;

import ch.bfh.due1.time.TimeSlot;

public abstract class AReservation {
	/* Setter */

	/**
	 * room to reservate
	 * @param room
	 *            the room
	 */
	public abstract void setRoom(ARoom room);

	/**
	 * date of the reservation
	 * @param timeSlot
	 *            the time slot
	 */
	public abstract void setTimeSlot(TimeSlot timeSlot);

	/**
	 * booker of the room
	 * @param booker
	 *            booker instance
	 */
	public abstract void setBooker(ABooker booker);

	/* Getter */
	/**
	 * get the Reservation's Room
	 * @return the Reservation's Room
	 */
	public abstract ARoom getRoom();

	/**
	 * get the Reservation's time slot
	 * @return the Reservation's time slot
	 */
	public abstract TimeSlot getTimeSlot();

	/**
	 * get the Reservation's Booker
	 * @return the Reservation's Booker
	 */
	public abstract ABooker getBooker();
}
