/**Copyright(c)2016 Berner Fachhochschule,Switzerland.*Project Smart Reservation System.*Distributable under GPL license.See terms of license at gnu.org.*/
package controllerTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import control.ASystemUser;
import control.LogInController;
import model.SystemUser;
import control.exceptions.UserLoginFailedException;

public class LogInControllerTest {

	@Test
	public void loginTest() {
		ASystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ASystemUser> userList = new ArrayList<ASystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("hans@zimmer.ch", "111");
		assertEquals(true, hans.isLoggedIn());
	}

	@Test
	public void logoutTest() {
		ASystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ASystemUser> userList = new ArrayList<ASystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogout("hans@zimmer.ch");
		assertEquals(false, hans.isLoggedIn());
	}

	@Test(expected = UserLoginFailedException.class)
	public void userNotExistsTest() {
		ASystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ASystemUser> userList = new ArrayList<ASystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("not@exists.ch", "111");
	}

	@Test(expected = UserLoginFailedException.class)
	public void wrongPwTest() {
		ASystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ASystemUser> userList = new ArrayList<ASystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("hans@zimmer.ch", "222");
	}

	@Test(expected = UserLoginFailedException.class)
	public void allreadyLoggedInTest() {
		ASystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ASystemUser> userList = new ArrayList<ASystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("hans@zimmer.ch", "111");

		lc.userLogin("hans@zimmer.ch", "111");
	}

	@Test(expected = UserLoginFailedException.class)
	public void emptyUserLoginTest() {
		ASystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ASystemUser> userList = new ArrayList<ASystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogin("", "");
		assertEquals(true, hans.isLoggedIn());
	}

	@Test(expected = UserLoginFailedException.class)
	public void emptyUserLogoutTest() {
		ASystemUser hans = new SystemUser("Hans", "Zimmer", "hans@zimmer.ch", "111", false);
		List<ASystemUser> userList = new ArrayList<ASystemUser>();
		userList.add(hans);

		LogInController lc = new LogInController(userList);
		lc.userLogout("");
		assertEquals(false, hans.isLoggedIn());
	}
}
