/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package srs;

public class Room {

	// Room
	private int size;
	private String name;
	private String description;
	private boolean isBooked;

	public Room(int s, String n, String d) {
		this.size = s;
		this.name = n;
		this.description = d;
		this.isBooked = false;
	}

	// Setter
	/**
	 * @param s
	 */
	public void setSize(int s) {
		this.size = s;
	}

	/**
	 * @param n
	 */
	public void setName(String n) {
		this.name = n;
	}

	/**
	 * @param d
	 */
	public void setDescription(String d) {
		this.description = d;
	}

	/**
	 * 
	 */
	public void setBooked() {
		this.isBooked = true;
	}

	/**
	 * 
	 */
	public void removeBooking() {
		this.isBooked = false;
	}

	// Getter
	/**
	 * @return
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return
	 */
	public boolean isBooked() {
		return this.isBooked;
	}
}
