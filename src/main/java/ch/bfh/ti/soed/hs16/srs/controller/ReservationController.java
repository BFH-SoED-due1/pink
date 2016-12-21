/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.controller;

import java.util.List;

import ch.bfh.due1.time.TimeSlot;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.ReservationException;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.ReservationNotFoundException;
import ch.bfh.ti.soed.hs16.srs.db.DataAccess;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IReservation;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IReservationController;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;

public class ReservationController implements IReservationController {
	/** Implementation for administrate the reservations */

	public ReservationController() {
	}

	/*
	 * @see controller.IReservationController#showReservations()
	 */
	@Override
	public List<IReservation> listAllReservations() {
		DataAccess dataAccess = DataAccess.getInstance();
		return dataAccess.getAllReservations();
	}

	/*
	 * @see controller.IReservationController#reservate(srs.Booker,
	 * java.util.Date, java.sql.Time, java.sql.Time, srs.Room)
	 */
	@Override
	public void reservate(IReservation reservation) {
		if (validateInput(reservation.getBooker(), reservation.getTimeSlot(), reservation.getRoom())) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.insertReservation(reservation);
			reservation.getRoom().setBooked();
		} else
			throw new ReservationException("Check your input. A booker needs a first name, last name, login, the room has to be free.");
	}

	/*
	 * @see controller.IReservationController#cancel(srs.Booker, java.util.Date,
	 * java.sql.Time, java.sql.Time, srs.Room)
	 */
	@Override
	public void cancel(IReservation reservation) {
		if (reservationExists(reservation.getId())) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.cancelReservation(reservation.getId());
			reservation.getRoom().removeBooking();
		}
	}

	public boolean validateInput(IBooker booker, TimeSlot timeSlot, IRoom room) {
		boolean isValid = false;

		if (room.isBooked() || timeSlot == null)
			isValid = false;
		else
			isValid = true;

		return isValid;
	}

	/**
	 * Checks if a reservation exists
	 * @param id
	 *            the uniqe id of the reservation
	 * @return true if reservation exists
	 */
	public boolean reservationExists(Long id) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<IReservation> reservationList = dataAccess.getAllReservations();
		boolean exists = false;
		for (int i = 0; i < reservationList.size(); i++) {
			if (reservationList.get(i).getId().equals(id)) {
				exists = true;
				break;
			}
		}
		if (!exists)
			throw new ReservationNotFoundException("Reservation not found!");

		return exists;
	}
}
