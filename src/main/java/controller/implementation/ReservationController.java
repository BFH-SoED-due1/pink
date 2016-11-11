/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import controller.IReservationController;
import controller.exceptions.ReservationNotFoundException;
import srs.Booker;
import srs.Reservation;
import srs.Room;

public class ReservationController implements IReservationController {
	/** Implementation for administrate the reservations */

	private List<Reservation> reservations;

	public ReservationController(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.IReservationController#showReservations()
	 */
	@Override
	public List<Reservation> showReservations() {
		return this.reservations;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.IReservationController#reservate(srs.Booker,
	 * java.util.Date, java.sql.Time, java.sql.Time, srs.Room)
	 */
	@Override
	public List<Reservation> reservate(Booker booker, Date date, Time from, Time to, Room room) {
		this.reservations.add(new Reservation(room, date, from, to, booker));
		return this.reservations;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.IReservationController#cancel(srs.Booker, java.util.Date,
	 * java.sql.Time, java.sql.Time, srs.Room)
	 */
	@Override
	public List<Reservation> cancel(Booker booker, Date date, Time from, Time to, Room room)
			throws ReservationNotFoundException {
		for (int i = 0; i < this.reservations.size(); i++) {
			if (this.reservations.get(i).getBooker().equals(booker) && this.reservations.get(i).getDate().equals(date)
					&& this.reservations.get(i).getFrom().equals(from) && this.reservations.get(i).getTo().equals(to)
					&& this.reservations.get(i).getRoom().equals(room))
				this.reservations.remove(i);
			else
				throw new ReservationNotFoundException("The reservation you are looking for, was not found.");
		}
		return this.reservations;
	}
}
