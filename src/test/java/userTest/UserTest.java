/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package userTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import user.User;

public class UserTest {

	// Test User-class

	private final String name = "Duck";
	private final String newName = "Mouse";
	private final String fName = "Donald";
	private final String newfName = "Mickey";
	private final String loggin = "donald@duck.ch";
	private final String newloggin = "mickey@mouse.ch";
	private final String password = "abc123";
	private final String newPassword = "def456";

	@Test
	public void test() {
		// initialization
		User usr = new User(name, fName, loggin, password);
		assertEquals(usr.getName(), name);

		// change value
		usr.setName(newName);
		assertEquals(usr.getName(), newName);
	}

	@Test
	public void testFName() {
		// initialization
		User usr = new User(name, fName, loggin, password);
		assertEquals(usr.getFirstName(), fName);

		// change value
		usr.setFristName(newfName);
		assertEquals(usr.getFirstName(), newfName);
	}

	@Test
	public void testLoogin() {
		// initialization
		User usr = new User(name, fName, loggin, password);
		assertEquals(usr.getLoggin(), loggin);

		// change value
		usr.setLoggin(newloggin);
		assertEquals(usr.getLoggin(), newloggin);
	}

	@Test
	public void testPassword() {
		// initialization
		User usr = new User(name, fName, loggin, password);
		assertEquals(usr.getPassword(), password);

		// change value
		usr.setPassword(newPassword);
		assertEquals(usr.getPassword(), newPassword);
	}

	@Test
	public void testIsUsr() {
		// initialization
		User usr = new User(name, fName, loggin, password);
		usr.setUser();

		assertTrue(usr.isUser());
		assertFalse(usr.isAdmin());

		// change value
		usr.removeUser();
		assertFalse(usr.isUser());
	}

	@Test
	public void testIsAdmin() {
		// initialization
		User usr = new User(name, fName, loggin, password);
		usr.setAdmin();

		assertTrue(usr.isAdmin());
		assertFalse(usr.isUser());

		// change value
		usr.removeAdmin();
		assertFalse(usr.isAdmin());
	}
}
