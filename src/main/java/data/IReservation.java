/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package data;

import java.sql.Time;
import java.util.Date;

import jpa.Booker;
import jpa.Room;

/**
 * @author Nathalie
 *
 */
public interface IReservation {
	/* Setter */

	/**room to reservate
	 * @param r the room*/
	public void setRoom(Room r);

	/**date of the reservation
	 * @param d the date*/
	public void setDate(Date d);

	/**set start time
	 * @param from start time*/
	public void setFrom(Time from);

	/**set end time
	 * @param to end time*/
	public void setTo(Time to);
	
	/**booker of the room
	 * @param b booker instance*/
	public void setBooker(Booker b);

	/* Getter */
	/**return reservated room*/
	public Room getRoom();

	/**return reservation date*/
	public Date getDate();
	
	/**return reservation start time*/
	public Date getFrom();

	/**return reservation end time*/
	public Date getTo();

	/**return the booker of the reservation*/
	public Booker getBooker();
}
