/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.model.RoomEquipment;

public class RoomEquipmentTest {

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
