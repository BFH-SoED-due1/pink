/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package usrTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usr.Admin;

public class AdminTest {

	// Test Admin-class

	private final String name = "Duck";
	private final String newName = "Mouse";
	private final String fName = "Donald";
	private final String newfName = "Mickey";
	private final String loggin = "donald@duck.ch";
	private final String newloggin = "mickey@mouse.ch";
	private final String password = "abc123";
	private final String newPassword = "def456";

	@Test
	public void testName() {
		// initialization
		Admin admin = new Admin(name, fName, loggin, password);
		assertEquals(admin.getName(), name);

		// change value
		admin.setName(newName);
		assertEquals(admin.getName(), newName);
	}

	@Test
	public void testFName() {
		// initialization
		Admin admin = new Admin(name, fName, loggin, password);
		assertEquals(admin.getFirstName(), fName);

		// change value
		admin.setFristName(newfName);
		assertEquals(admin.getFirstName(), newfName);
	}

	@Test
	public void testLoogin() {
		// initialization
		Admin admin = new Admin(name, fName, loggin, password);
		assertEquals(admin.getLoggin(), loggin);

		// change value
		admin.setLoggin(newloggin);
		assertEquals(admin.getLoggin(), newloggin);
	}

	@Test
	public void testPassword() {
		// initialization
		Admin admin = new Admin(name, fName, loggin, password);
		assertEquals(admin.getPassword(), password);

		// change value
		admin.setPassword(newPassword);
		assertEquals(admin.getPassword(), newPassword);
	}

	@Test
	public void testIsUsr() {
		// initialization
		Admin admin = new Admin(name, fName, loggin, password);
		admin.setUser();

		assertTrue(admin.isUser());
		assertFalse(admin.isAdmin());

		// change value
		admin.removeUser();
		assertFalse(admin.isAdmin());
		assertTrue(admin.isUser());
	}

	@Test
	public void testIsAdmin() {
		// initialization
		Admin admin = new Admin(name, fName, loggin, password);
		admin.setAdmin();

		assertTrue(admin.isAdmin());
		assertFalse(admin.isUser());

		// change value
		admin.removeAdmin();
		assertTrue(admin.isUser());
		assertFalse(admin.isAdmin());
	}
}
