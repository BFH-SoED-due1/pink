/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.view;

import java.util.List;

import ch.bfh.ti.soed.hs16.srs.controller.exceptions.ReservationNotFoundException;
import ch.bfh.ti.soed.hs16.srs.model.IReservation;

public interface IReservationController {
	/** Responsible for administrate the reservations */

	/**
	 * Reserve a room
	 * @param reservation the reservation
	 * @return the adapted list
	 */
	public List<IReservation> reservate(IReservation reservation);

	/**
	 * Cancel a reservation
	 * @param reservation the reservation
	 * @return the adapted list
	 * @throws ReservationNotFoundException
	 */
	public List<IReservation> cancel(IReservation reservation) throws ReservationNotFoundException;

	/**
	 * Show all reservations
	 * @return the list with all reservations
	 */
	public List<IReservation> showReservations();

}
