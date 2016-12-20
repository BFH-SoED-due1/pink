/**Copyright(c)2016 Berner Fachhochschule,Switzerland.*Project Smart Reservation System.*Distributable under GPL license.See terms of license at gnu.org.*/
package ch.bfh.ti.soed.hs16.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.controller.LogInController;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.UserLoginFailedException;
import ch.bfh.ti.soed.hs16.srs.model.SystemUser;
import ch.bfh.ti.soed.hs16.srs.srsInterface.ISystemUser;

public class LogInControllerTest {
	private LogInController userController;

	@Before
	public void setUp() {
		this.userController = new LogInController();
	}

	@Test
	public void saveUserTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans1@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);

		List<ISystemUser> users = this.userController.listAllUsers();
		ISystemUser u = this.userController.getUserByEmail(email);

		assertTrue(users.contains(u));
	}

	@Test(expected = UserLoginFailedException.class)
	public void saveUserTwiceTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans2@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);
		this.userController.saveUser(firstName, lastName, email, password, isAdmin);
	}

	@Test(expected = IllegalArgumentException.class)
	public void saveEmptyUserTest() {
		String firstName = "";
		String lastName = "";
		String email = "";
		String password = "";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);
	}

	@Test
	public void deleteBookerTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans3@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);

		ISystemUser u = this.userController.getUserByEmail(email);

		this.userController.deleteUser(u);

		List<ISystemUser> users = this.userController.listAllUsers();

		assertFalse(users.contains(u));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteNotExistingUserTest() {
		ISystemUser donald = new SystemUser("Donald", "Duck", "donald@duck.com", "111", false);

		this.userController.deleteUser(donald);
	}

	@Test
	public void editBookerTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans4@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);

		ISystemUser u = this.userController.getUserByEmail(email);
		String newFname = "Hansi";
		String newLname = "Musti";
		String newPassword = "222";

		this.userController.editUser(newFname, newLname, newPassword, u);

		assertEquals(newFname, u.getFirstName());
		assertEquals(newLname, u.getLastName());
		assertEquals(newPassword, u.getPassword());
	}

	@Test(expected = IllegalArgumentException.class)
	public void editWrongBookerTest() {
		ISystemUser u = new SystemUser("Dagobert", "Duck", "dagobert@duck.ch", "111", false);

		this.userController.editUser("Dagi", "Duck", "222", u);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getWrongBookerByNameTest() {
		this.userController.getUserByEmail("du@hast.ch");
	}

	@Test(expected = IllegalArgumentException.class)
	public void editEmptyBookerTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans5@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);

		ISystemUser u = this.userController.getUserByEmail(email);

		this.userController.editUser("", "", "", u);
	}

	@Test
	public void setUserAdminTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hans6@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);

		ISystemUser u = this.userController.getUserByEmail(email);

		assertEquals(isAdmin, u.isAdmin());

		isAdmin = true;
		this.userController.setUserAdmin(isAdmin, u);

		assertEquals(isAdmin, u.isAdmin());
	}

	@Test
	public void loginTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hansli1@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);

		this.userController.userLogin(email, password);

		ISystemUser user = this.userController.getUserByEmail(email);

		assertEquals(true, user.isLoggedIn());
	}

	@Test
	public void logoutTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hansli2@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);

		this.userController.userLogin(email, password);
		this.userController.userLogout(email);

		ISystemUser user = this.userController.getUserByEmail(email);

		assertEquals(false, user.isLoggedIn());
	}

	@Test(expected = UserLoginFailedException.class)
	public void loginUserNotExistsTest() {
		this.userController.userLogin("not@exists.ch", "111");
	}

	@Test(expected = UserLoginFailedException.class)
	public void wrongPwTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hansli3@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);

		this.userController.userLogin(email, "222");
	}

	@Test(expected = UserLoginFailedException.class)
	public void allreadyLoggedInTest() {
		String firstName = "Hans";
		String lastName = "Muster";
		String email = "hansli4@muster.ch";
		String password = "111";
		boolean isAdmin = true;

		this.userController.saveUser(firstName, lastName, email, password, isAdmin);

		this.userController.userLogin(email, password);
		this.userController.userLogin(email, password);
	}

	@Test(expected = UserLoginFailedException.class)
	public void emptyUserLoginTest() {
		this.userController.userLogin("", "");
	}

	@Test(expected = UserLoginFailedException.class)
	public void emptyUserLogoutTest() {
		this.userController.userLogout("");
	}
}
