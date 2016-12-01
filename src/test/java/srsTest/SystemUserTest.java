/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package srsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jpa.SystemUser;

public class SystemUserTest {
	/* Test SystemUser-class */
	private final String firstName = "Donald";
	private final String newFirstName = "Mickey";
	private final String lastName = "Duck";
	private final String newLastName = "Mouse";
	private final String email = "donald@duck.ch";
	private final String newEmail = "mickey@mouse.ch";
	private final String password = "abc123";
	private final String newPassword = "def456";

	@Test
	public void testFirstName() {
		// initialization
		SystemUser usr = new SystemUser(firstName, lastName, email, password, false);
		assertEquals(usr.getFirstName(), firstName);

		// change value
		usr.setFirstName(newFirstName);
		assertEquals(usr.getFirstName(), newFirstName);
	}

	@Test
	public void testLastName() {
		// initialization
		SystemUser usr = new SystemUser(firstName, lastName, email, password, false);
		assertEquals(usr.getLastName(), lastName);

		// change value
		usr.setLastName(newLastName);
		assertEquals(usr.getLastName(), newLastName);
	}

	@Test
	public void testLoogin() {
		// initialization
		SystemUser usr = new SystemUser(firstName, lastName, email, password, false);
		assertEquals(usr.getLogin(), email);

		// change value
		usr.setLogin(newEmail);
		assertEquals(usr.getLogin(), newEmail);
	}

	@Test
	public void testPassword() {
		// initialization
		SystemUser usr = new SystemUser(firstName, lastName, email, password, false);
		assertEquals(usr.getPassword(), password);

		// change value
		usr.setPassword(newPassword);
		assertEquals(usr.getPassword(), newPassword);
	}

	@Test
	public void testIsAdmin() {
		// initialization
		SystemUser usr = new SystemUser(firstName, lastName, email, password, false);
		usr.setAdmin();

		assertTrue(usr.isAdmin());

		// change value
		usr.removeAdmin();
		assertFalse(usr.isAdmin());
	}
}
