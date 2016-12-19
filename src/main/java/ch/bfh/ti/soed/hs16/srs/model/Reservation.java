/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.bfh.due1.time.TimeSlot;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IReservation;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;

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

	public Reservation(IRoom r2, TimeSlot timeSlot, IBooker booker) {
		this.room = (Room) r2;
		this.timeSlot = timeSlot;
		this.booker = (Booker) booker;
	}

	/* Setter */
	@Override
	public void setRoom(IRoom room) {
		this.room = (Room) room;
	}

	@Override
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	@Override
	public void setBooker(IBooker booker) {
		this.booker = (Booker) booker;
	}

	/* Getter */
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public IRoom getRoom() {
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
