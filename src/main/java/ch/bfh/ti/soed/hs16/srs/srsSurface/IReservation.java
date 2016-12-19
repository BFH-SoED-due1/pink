/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.srsSurface;

import ch.bfh.due1.time.TimeSlot;

/**
 * @author Nathalie
 *
 */
public interface IReservation {
	/* Setter */

	/**
	 * room to reservate
	 * @param room the room
	 */
	public void setRoom(IRoom room);

	/**
	 * date of the reservation
	 * @param timeSlot the time slot
	 */
	public void setTimeSlot(TimeSlot timeSlot);

	/**
	 * booker of the room
	 * @param booker booker instance
	 */
	public void setBooker(IBooker booker);

	/* Getter */
	/**
	 * get the Reservation's Room
	 * @return the Reservation's Room
	 */
	public IRoom getRoom();

	/**
	 * get the Reservation's time slot
	 * @return the Reservation's time slot
	 */
	public TimeSlot getTimeSlot();

	/**
	 * get the Reservation's Booker
	 * @return the Reservation's Booker
	 */
	public IBooker getBooker();

	/**
	 * @return return the reservation-id
	 */
	public Long getId();
}
