/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.bfh.due1.time.TimeSlot;
import control.ABooker;
import control.AReservation;
import control.ARoom;

@Entity(name = "Reservation")
public class Reservation extends AReservation {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(targetEntity = Room.class)
	private Room room;

	private TimeSlot timeSlot;

	@ManyToOne(targetEntity = Booker.class)
	private Booker booker;

	public Reservation() {
	}

	public Reservation(Room r2, TimeSlot timeSlot, Booker booker) {
		this.room = r2;
		this.timeSlot = timeSlot;
		this.booker = booker;
	}

	/* Setter */
	@Override
	public void setRoom(ARoom room) {
		this.room = (Room) room;
	}

	@Override
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	@Override
	public void setBooker(ABooker booker) {
		this.booker = (Booker) booker;
	}

	/* Getter */
	public Long getId() {
		return this.id;
	}

	@Override
	public Room getRoom() {
		return room;
	}

	@Override
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	@Override
	public Booker getBooker() {
		return booker;
	}
}
