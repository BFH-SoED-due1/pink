/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controllerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import srs.SystemUser;

public class LogInControllerTest {

	private List<SystemUser> userList = new ArrayList<SystemUser>();

	SystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);

	@Test
	public void loginTest() {
		userList.add(hans);
	}

}
