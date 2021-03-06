/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;

@Entity(name = "Room")
public class Room implements IRoom {
	@Id
	@GeneratedValue
	private Long id;

	private int size;
	private String name;
	private String description;

	@OneToMany
	private List<RoomEquipment> equipmentList;

	private boolean isBooked;

	@OneToMany(targetEntity = Reservation.class)
	private List<Reservation> reservations;

	public Room() {
	}

	public Room(int size, String name, String descr) {
		equipmentList = new ArrayList<RoomEquipment>();
		this.size = size;
		this.name = name;
		this.description = descr;
		this.isBooked = false;
	}

	public void addEquipment(RoomEquipment equipment) {
		this.equipmentList.add(equipment);
	}

	public void removeEquipment(RoomEquipment equipment) {
		this.equipmentList.remove(equipment);
	}

	///////////////////////// Setter /////////////////////////
	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setDescription(String descr) {
		this.description = descr;
	}

	@Override
	public void setBooked() {
		this.isBooked = true;
	}

	@Override
	public void removeBooking() {
		this.isBooked = false;
	}

	///////////////////////// Getter /////////////////////////
	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean isBooked() {
		return this.isBooked;
	}

	@Override
	public List<RoomEquipment> getEquipmentList() {
		return equipmentList;
	}
}
