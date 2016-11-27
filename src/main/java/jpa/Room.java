/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package jpa;

import java.util.ArrayList;
import java.util.List;

public class Room {
	// Room
	private int size;
	private String name;
	private String description;
	private List<RoomEquipment> equipmentList;
	private boolean isBooked;

	public Room(int size, String name, String descr) {
		equipmentList = new ArrayList<RoomEquipment>();
		setSize(size);
		setName(name);
		setDescription(descr);
		this.isBooked = false;
	}

	public List<RoomEquipment> addEquipment(RoomEquipment equipment) {
		this.equipmentList.add(equipment);
		return equipmentList;
	}

	public List<RoomEquipment> removeEquipment(RoomEquipment equipment) {
		this.equipmentList.remove(equipment);
		return equipmentList;
	}

	///////////////////////// Setter /////////////////////////
	public void setSize(int s) {
		if (s <= 0) {
			throw new IllegalArgumentException("The size of a Room can not be 0 or smaller!");
		} else
			this.size = s;
	}

	public void setName(String n) {
		if (n.length() <= 0) {
			throw new IllegalArgumentException("The name of a Room can not be empty!");
		} else
			this.name = n;
	}

	public void setDescription(String d) {
		this.description = d;
	}

	public void setBooked() {
		this.isBooked = true;
	}

	public void removeBooking() {
		this.isBooked = false;
	}

	///////////////////////// Getter /////////////////////////
	public int getSize() {
		return this.size;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public boolean isBooked() {
		return this.isBooked;
	}

	public List<RoomEquipment> getEquipmentList() {
		return equipmentList;
	}
}
