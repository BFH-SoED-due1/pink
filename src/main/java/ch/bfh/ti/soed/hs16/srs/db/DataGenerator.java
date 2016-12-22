/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.db;

import ch.bfh.ti.soed.hs16.srs.model.RoomEquipment;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;

public class DataGenerator {

	public static void create() {
		DataAccess dataAccess = DataAccess.getInstance();
		// make a few persons
		dataAccess.registerBooker("Frodo", "Beutlin", "frodo@beutlin.ch");
		dataAccess.registerBooker("Gandalf", "Graurock", "gandalf@graurock.ch");
		dataAccess.registerBooker("Gimmli", "Gloins Sohn", "gimmli@gloinssohn.ch");
		dataAccess.registerBooker("Legolas", "Greenleaf", "legolas@greenleaf.ch");
		// make a few rooms
		IRoom room = dataAccess.insertRoom(64, "4006", "Classroom");
		dataAccess.insertRoom(58, "4008", "Conference Room");
		dataAccess.insertRoom(89, "4012", "Classroom");
		dataAccess.insertRoom(22, "4999", "Toilet");
		// make a few roomequipments
		RoomEquipment eq = dataAccess.insertRoomEquipment("Beamer", 1);
		dataAccess.addEquipment(eq, room.getId());
		// make one systemuser
		dataAccess.registerSystemUser("admin", "admin", "admin@admi.ch", "admin", true);
	}
}
