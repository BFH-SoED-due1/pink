/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "RoomEquipment")
public class RoomEquipment {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private int quantity;

	public RoomEquipment() {
	}

	public RoomEquipment(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int qty) {
		this.quantity = qty;
	}
}
