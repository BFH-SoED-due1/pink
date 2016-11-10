/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package srs;

import java.sql.Time;
import java.util.Date;

public class Reservation {
	private Room room;
	private Date date;
	private Time from, to;
	private Booker booker;

	public Reservation(Room r, Date d, Time from, Time to, Booker b) {
		this.room = r;
		this.date = d;
		this.from = from;
		this.to = to;
		this.booker = b;
	}

	/*Setter*/
	/**@param r room*/
	public void setRoom(Room r) {
		this.room = r;
	}
	
	/**@param d date*/
	public void setDate(Date d) {
		this.date = d;
	}

	/**@param from starting time*/
	public void setFrom(Time from) {
		this.from = from;
	}

	/**@param from starting time*/
	public void setTo(Time to) {
		this.to = to;
	}

	/**@param b booker*/
	public void setBooker(Booker b) {
		this.booker = b;
	}

	/*Getter*/
	public Room getRoom() {
		return room;
	}

	public Date getDate() {
		return date;
	}

	public Date getFrom() {
		return from;
	}

	public Date getTo() {
		return to;
	}

	public Booker getBooker() {
		return booker;
	}
}
