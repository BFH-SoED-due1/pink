/**Copyright(c)2016 Berner Fachhochschule,Switzerland.*Project Smart Reservation System.*Distributable under GPL license.See terms of license at gnu.org.*/
package ch.bfh.ti.soed.hs16.controllerTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.controller.LogInController;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.UserLoginFailedException;
import ch.bfh.ti.soed.hs16.srs.model.ISystemUser;
import ch.bfh.ti.soed.hs16.srs.model.SystemUser;

public class LogInControllerTest {

	@Test
	public void loginTest() {
		ISystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ISystemUser> userList = new ArrayList<ISystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("hans@zimmer.ch", "111");
		assertEquals(true, hans.isLoggedIn());
	}

	@Test
	public void logoutTest() {
		ISystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ISystemUser> userList = new ArrayList<ISystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogout("hans@zimmer.ch");
		assertEquals(false, hans.isLoggedIn());
	}

	@Test(expected = UserLoginFailedException.class)
	public void userNotExistsTest() {
		ISystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ISystemUser> userList = new ArrayList<ISystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("not@exists.ch", "111");
	}

	@Test(expected = UserLoginFailedException.class)
	public void wrongPwTest() {
		ISystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ISystemUser> userList = new ArrayList<ISystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("hans@zimmer.ch", "222");
	}

	@Test(expected = UserLoginFailedException.class)
	public void allreadyLoggedInTest() {
		ISystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ISystemUser> userList = new ArrayList<ISystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("hans@zimmer.ch", "111");

		lc.userLogin("hans@zimmer.ch", "111");
	}

	@Test(expected = UserLoginFailedException.class)
	public void emptyUserLoginTest() {
		ISystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ISystemUser> userList = new ArrayList<ISystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("", "");
		assertEquals(true, hans.isLoggedIn());
	}

	@Test(expected = UserLoginFailedException.class)
	public void emptyUserLogoutTest() {
		ISystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ISystemUser> userList = new ArrayList<ISystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogout("");
		assertEquals(false, hans.isLoggedIn());
	}
}
