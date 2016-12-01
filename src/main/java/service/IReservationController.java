/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service;

import java.util.List;

import ch.bfh.due1.time.TimeSlot;
import jpa.Booker;
import jpa.Reservation;
import jpa.Room;
import service.implementation.exceptions.ReservationNotFoundException;

public interface IReservationController {
	/** Responsible for administrate the reservations */

	/**
	 * Reserve a room
	 * @param booker
	 *            booker who want to reservate a roome
	 * @param timeSlot
	 *            time slot
	 * @param room
	 *            the room to reserve
	 * @return the adapted list
	 */
	public List<Reservation> reservate(Booker booker, TimeSlot timeSlot, Room room);

	/**
	 * Cancel a reservation
	 * @param booker
	 *            booker who want to reservate a roome
	 * @param timeSlot
	 *            time slot
	 * @param room
	 *            the room to reserve
	 * @throws ReservationNotFoundException
	 *             if reservation will not be found
	 * @return the adapted list
	 */
	public List<Reservation> cancel(Booker booker, TimeSlot timeSlot, Room room) throws ReservationNotFoundException;

	/**
	 * Show all reservations
	 * @return the list with all reservations
	 */
	public List<Reservation> showReservations();

}
