/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package srsTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jpa.RoomEquipment;

public class RoomEquipmentTest {

	@Test
	public void testEquipmentName() {
		String name = "Blackboard";
		int qty = 1;
		String newName = "Beamer";

		RoomEquipment eq = new RoomEquipment(name, qty);
		assertEquals(name, eq.getName());

		eq.setName(newName);
		assertEquals(newName, eq.getName());
	}

	@Test
	public void testEquipmentQuantity() {
		String name = "Beamer";
		int qty = 1;
		int newQty = 2;

		RoomEquipment eq = new RoomEquipment(name, qty);
		assertEquals(qty, eq.getQuantity());

		eq.setQuantity(newQty);
		assertEquals(newQty, eq.getQuantity());
	}

}