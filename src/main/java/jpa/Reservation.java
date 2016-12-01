/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.bfh.due1.time.TimeSlot;
import data.IReservation;

@Entity(name = "Reservation")
public class Reservation implements IReservation {
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

	public Reservation(Room room, TimeSlot timeSlot, Booker booker) {
		this.room = room;
		this.timeSlot = timeSlot;
		this.booker = booker;
	}

	/* Setter */
	@Override
	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	@Override
	public void setBooker(Booker booker) {
		this.booker = booker;
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
