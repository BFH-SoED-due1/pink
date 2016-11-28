/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package srsTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.DataAccess;
import jpa.Booker;

public class DataAccessTest {
	private DataAccess dataAccess;

	@Before
	public void setUp() {
		this.dataAccess = DataAccess.getInstance();
	}

	@Test
	public void testDataLayerAvailable() {
		assertNotNull(dataAccess);
	}

	@Test
	public void testregisterBooker() {
		String firstName = "Albert";
		String lastName = "Lee";
		String email = "albert@lee.org";
		Booker b = this.dataAccess.registerBooker(firstName, lastName, email);
		List<Booker> all = this.dataAccess.getAllBookers();
		assertNotNull(all);
		assertTrue(all.size() > 0);
		assertTrue(all.contains(b));
	}

}
