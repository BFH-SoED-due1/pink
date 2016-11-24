/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import jpa.Booker;
import jpa.Reservation;
import jpa.Room;
import service.implementation.exceptions.ReservationNotFoundException;

public interface IReservationController {
	/** Responsible for administrate the reservations */

	/**
	 * Reserve a room
	 * @param b booker who want to reservate a roome
	 * @param d date
	 * @param from starting time
	 * @param to end time
	 * @param r the room to reserve
	 * @return the adapted list
	 */
	public List<Reservation> reservate(Booker b, Date d, Time from, Time to, Room r);

	/**
	 * Cancel a reservation
	 * @param b booker who want to reservate a roome
	 * @param d date
	 * @param from starting time
	 * @param to end time
	 * @param r the room to reserve
	 * @throws ReservationNotFoundException if reservation will not be found
	 * @return the adapted list
	 */
	public List<Reservation> cancel(Booker b, Date d, Time from, Time to, Room r) throws ReservationNotFoundException;

	/**
	 * Show all reservations
	 * @return the list with all reservations
	 */
	public List<Reservation> showReservations();

}
