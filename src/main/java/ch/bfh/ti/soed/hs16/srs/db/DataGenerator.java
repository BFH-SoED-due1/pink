/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.db;

import java.time.LocalDateTime;

import ch.bfh.due1.time.TimeSlot;
import ch.bfh.due1.time.TimeSlotFactory;
import ch.bfh.ti.soed.hs16.srs.model.Reservation;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IReservation;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;

public class DataGenerator {

	public static void create() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		DataAccess dataAccess = DataAccess.getInstance();
		// make a few persons
		IBooker booker = dataAccess.registerBooker("Frodo", "Beutlin", "frodo@beutlin.ch");
		dataAccess.registerBooker("Gandalf", "Graurock", "gandalf@graurock.ch");
		dataAccess.registerBooker("Gimmli", "Gloins Sohn", "gimmli@gloinssohn.ch");
		dataAccess.registerBooker("Legolas", "Greenleaf", "legolas@greenleaf.ch");
		// make a few rooms
		IRoom room = dataAccess.insertRoom(64, "4006", "Classroom");
		dataAccess.insertRoom(58, "4008", "Conference Room");
		dataAccess.insertRoom(89, "4012", "Classroom");
		dataAccess.insertRoom(22, "4999", "Toilet");
		// make a few reservations
		LocalDateTime start = LocalDateTime.of(2016, 11, 24, 9, 15);
		LocalDateTime finish = LocalDateTime.of(2016, 11, 24, 9, 45);
		String className = System.getProperty("timeslotfactory.name", "ch.bfh.due1.time.pojo.TimeSlotFactoryImpl");
		Class<?> clazz = Class.forName(className);
		TimeSlotFactory factory = (TimeSlotFactory) clazz.newInstance();
		TimeSlot timeSlot = factory.createTimeSlot(start, finish);
		IReservation reservation = new Reservation(room, timeSlot, booker);
		dataAccess.insertReservation(reservation);
	}
}
