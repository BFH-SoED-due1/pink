/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package data;

/**
 * @author Nathalie
 *
 */
public interface IRoom {
	/**set room size
	 * @param s the size of the room*/
	public void setSize(int s);

	/**set the room name
	 * @param n the name of the room*/
	public void setName(String n);

	/**set the description of the room
	 * @param d the room description*/
	public void setDescription(String d);
	
	/**true if the room is reservated*/
	public void setBooked();
	
	/**remove the booking*/
	public void removeBooking();

	/**get the size of the room*/
	public int getSize();

	/**get the name of th room*/
	public String getName();

	/**get the description of the room*/
	public String getDescription();
	
	/**returns true if room is booked*/
	public boolean isBooked();
}
