/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service.implementation;

import java.util.List;

import ch.bfh.due1.time.TimeSlot;
import jpa.Booker;
import jpa.Reservation;
import jpa.Room;
import service.IReservationController;
import service.implementation.exceptions.ReservationException;
import service.implementation.exceptions.ReservationNotFoundException;

public class ReservationController implements IReservationController {
	/** Implementation for administrate the reservations */

	private List<Reservation> reservationList;

	public ReservationController(List<Reservation> reservations) {
		this.reservationList = reservations;
	}

	/*
	 * @see controller.IReservationController#showReservations()
	 */
	@Override
	public List<Reservation> showReservations() {
		return this.reservationList;
	}

	/*
	 * @see controller.IReservationController#reservate(srs.Booker,
	 * java.util.Date, java.sql.Time, java.sql.Time, srs.Room)
	 */
	@Override
	public List<Reservation> reservate(Booker booker, TimeSlot timeSlot, Room room) {
		if (validateInput(booker, timeSlot, room)) {
			this.reservationList.add(new Reservation(room, timeSlot, booker));
			room.setBooked();
			return this.reservationList;
		} else
			throw new ReservationException("Check your input. A booker needs a first name, last name, login, the room has to be free.");
	}

	/*
	 * @see controller.IReservationController#cancel(srs.Booker, java.util.Date,
	 * java.sql.Time, java.sql.Time, srs.Room)
	 */
	@Override
	public List<Reservation> cancel(Booker booker, TimeSlot timeSlot, Room room) throws ReservationNotFoundException {
		for (int i = 0; i < this.reservationList.size(); i++) {
			if (this.reservationList.get(i).getBooker().equals(booker) && this.reservationList.get(i).getTimeSlot().equals(timeSlot)
					&& this.reservationList.get(i).getRoom().equals(room))
				this.reservationList.remove(i);
			else
				throw new ReservationNotFoundException("The reservation you are looking for, was not found.");
		}
		return this.reservationList;
	}

	public boolean validateInput(Booker booker, TimeSlot timeSlot, Room room) {
		boolean isValid = false;

		if (booker.getFirstName().isEmpty() || booker.getLastName().isEmpty() || room.isBooked() || booker.getFirstName().isEmpty()
				|| booker.getLastName().isEmpty() || booker.getLogin().isEmpty() || timeSlot == null)
			isValid = false;
		else
			isValid = true;

		return isValid;
	}
}
