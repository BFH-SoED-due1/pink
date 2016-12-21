/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.srsInterface;

import java.util.List;

public interface IReservationController {
	/** Responsible for administrate the reservations */

	/**
	 * Reserve a room
	 * @param reservation
	 *            the reservation
	 */
	public void reservate(IReservation reservation);

	/**
	 * Cancel a reservation
	 * @param reservation
	 *            the reservation
	 */
	public void cancel(IReservation reservation);

	/**
	 * Show all reservations
	 * @return the list with all reservations
	 */
	public List<IReservation> listAllReservations();

}
