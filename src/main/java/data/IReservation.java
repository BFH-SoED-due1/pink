/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package data;

import ch.bfh.due1.time.TimeSlot;
import jpa.Booker;
import jpa.Room;

/**
 * @author Nathalie
 *
 */
public interface IReservation {
	/* Setter */

	/**
	 * room to reservate
	 * @param room
	 *            the room
	 */
	public void setRoom(Room room);

	/**
	 * date of the reservation
	 * @param timeSlot
	 *            the time slot
	 */
	public void setTimeSlot(TimeSlot timeSlot);

	/**
	 * booker of the room
	 * @param booker
	 *            booker instance
	 */
	public void setBooker(Booker booker);

	/* Getter */
	/**
	 * get the Reservation's Room
	 * @return the Reservation's Room
	 */
	public Room getRoom();

	/**
	 * get the Reservation's time slot
	 * @return the Reservation's time slot
	 */
	public TimeSlot getTimeSlot();

	/**
	 * get the Reservation's Booker
	 * @return the Reservation's Booker
	 */
	public Booker getBooker();
}
