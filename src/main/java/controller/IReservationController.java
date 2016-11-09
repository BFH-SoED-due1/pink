/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import srs.Booker;
import srs.Reservation;
import srs.Room;

public interface IReservationController {
	/**Responsible for administrate the reservations*/

	/**Reserve a room
	 * @param reservations: all reservations in srs
	 * @param b: booker who want to reservate a roome
	 * @param d: date
	 * @param from: starting time
	 * @param to: end time
	 * @param r: the room to reserve*/
	public void reservate(List<Reservation> reservations, Booker b, Date d, Time from, Time to, Room r);

	/**Cancel a reservation
	 * @param reservations: all reservations in srs
	 * @param b: booker who want to reservate a roome
	 * @param d: date
	 * @param from: starting time
	 * @param to: end time
	 * @param r: the room to reserve*/
	public void cacel(List<Reservation> reservations, Booker b, Date d, Time from, Time to, Room r);

	/**Show all reservations
	 * @return the list with all reservations
	 */
	public List<Reservation> showReservations();

	/**show only the reservated rooms
	 * @param reservations: all reservations in srs
	 * @return the list with all reservations*/
	public List<Reservation> showReservatedRooms(List<Reservation> reservations);

	/**show only free rooms
	 * @param reservations: all reservations in srs
	 * @return the list with all reservations*/
	public List<Reservation> showFreeRooms(List<Reservation> reservations);

}
