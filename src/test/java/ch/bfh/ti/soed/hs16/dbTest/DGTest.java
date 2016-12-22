/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.dbTest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.controller.BookerController;
import ch.bfh.ti.soed.hs16.srs.controller.RoomController;
import ch.bfh.ti.soed.hs16.srs.db.DataGenerator;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IRoom;

public class DGTest {
	private RoomController roomController;
	private BookerController bookerController;

	@Before
	public void setUp() throws Exception {
		this.roomController = new RoomController();
		this.bookerController = new BookerController();
		DataGenerator.create();
	}

	@Test
	public void test() {
		List<IRoom> roomList = roomController.listAllRooms();
		List<IBooker> bookerList = bookerController.listAllBookers();

		assertTrue(roomList.size() == 4);
		assertTrue(bookerList.size() == 4);
	}

}
