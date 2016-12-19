/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.srsInterface;

import java.util.List;

import ch.bfh.ti.soed.hs16.srs.model.RoomEquipment;

/**
 * @author Nathalie
 *
 */
public interface IRoom {
	/**
	 * set room size
	 * @param s the size of the room
	 */
	public void setSize(int s);

	/**
	 * set the room name
	 * @param n the name of the room
	 */
	public void setName(String n);

	/**
	 * set the description of the room
	 * @param d the room description
	 */
	public void setDescription(String d);

	/** true if the room is reservated */
	public void setBooked();

	/** remove the booking */
	public void removeBooking();

	/**
	 * get the size of the room
	 * @return the Room's size
	 */
	public int getSize();

	/**
	 * get the name of th room
	 * @return the Room's name
	 */
	public String getName();

	/**
	 * get the description of the room
	 * @return the Room's description
	 */
	public String getDescription();

	/**
	 * returns true if room is booked
	 * @return true if Room is booked
	 */
	public boolean isBooked();

	/**
	 * @return the id of the room
	 */
	public long getId();

	/**
	 * @return list of available equipment
	 */
	public List<RoomEquipment> getEquipmentList();

}
