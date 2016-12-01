/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import control.ARoom;

@Entity(name = "Room")
public class Room extends ARoom {
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
	public void setSize(int size) {
		this.size = size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String descr) {
		this.description = descr;
	}

	public void setBooked() {
		this.isBooked = true;
	}

	public void removeBooking() {
		this.isBooked = false;
	}

	///////////////////////// Getter /////////////////////////
	public Long getId() {
		return this.id;
	}

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

	// @Override
	// public List<Reservation> getReservations() {
	// return this.reservations;
	// }
	//
	// @Override
	// public void addReservation(Reservation reservation) {
	// this.reservations.add(reservation);
	// }
	//
	// @Override
	// public void removeReservation(Reservation reservation) {
	// this.reservations.remove(reservation);
	// }

}