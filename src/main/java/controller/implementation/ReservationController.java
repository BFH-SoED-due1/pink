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
import srs.Booker;
import srs.Reservation;
import srs.Room;

public class ReservationController implements IReservationController {
	/** Implementation for administrate the reservations */

	@Override
	public void reservate(List<Reservation> reservations, Booker b, Date d, Time from, Time to, Room r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cacel(List<Reservation> reservations, Booker b, Date d, Time from, Time to, Room r) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reservation> showReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> showReservatedRooms(List<Reservation> reservations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> showFreeRooms(List<Reservation> reservations) {
		// TODO Auto-generated method stub
		return null;
	}
}
