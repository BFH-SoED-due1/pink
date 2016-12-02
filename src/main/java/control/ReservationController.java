/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package control;

import java.util.List;

import ch.bfh.due1.time.TimeSlot;
import control.exceptions.ReservationException;
import control.exceptions.ReservationNotFoundException;
import view.IReservationController;

public class ReservationController implements IReservationController {
	/** Implementation for administrate the reservations */

	private List<AReservation> reservationList;

	public ReservationController(List<AReservation> reservations) {
		this.reservationList = reservations;
	}

	/*
	 * @see controller.IReservationController#showReservations()
	 */
	@Override
	public List<AReservation> showReservations() {
		return this.reservationList;
	}

	/*
	 * @see controller.IReservationController#reservate(srs.Booker,
	 * java.util.Date, java.sql.Time, java.sql.Time, srs.Room)
	 */
	@Override
	public List<AReservation> reservate(AReservation reservation) {
		if (validateInput(reservation.getBooker(), reservation.getTimeSlot(), reservation.getRoom())) {
			reservation.getRoom().setBooked();
			this.reservationList.add(reservation);
			return this.reservationList;
		} else
			throw new ReservationException(
					"Check your input. A booker needs a first name, last name, login, the room has to be free.");
	}

	/*
	 * @see controller.IReservationController#cancel(srs.Booker, java.util.Date,
	 * java.sql.Time, java.sql.Time, srs.Room)
	 */
	@SuppressWarnings("unused")
	@Override
	public List<AReservation> cancel(AReservation reservation) throws ReservationNotFoundException {
		for (int i = 0; i < this.reservationList.size(); i++) {
			if (this.reservationList.get(i).getBooker().equals(reservation.getBooker())
					&& this.reservationList.get(i).getBooker().equals(reservation.getRoom())
					&& this.reservationList.get(i).getBooker().equals(reservation.getTimeSlot())) {
				this.reservationList.remove(i);
				reservation.getRoom().removeBooking();
				break;
			} else {
				throw new ReservationNotFoundException("Reservation not found");
			}

		}
		return this.reservationList;
	}

	public boolean validateInput(ABooker booker, TimeSlot timeSlot, ARoom room) {
		boolean isValid = false;

		if (booker.getFirstName().isEmpty() || booker.getLastName().isEmpty() || room.isBooked()
				|| booker.getFirstName().isEmpty() || booker.getLastName().isEmpty() || booker.getLogin().isEmpty()
				|| timeSlot == null)
			isValid = false;
		else
			isValid = true;

		return isValid;
	}
}
