/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package control;

import java.util.ArrayList;
import java.util.List;

import exceptions.UserLoginFailedException;
import model.ASystemUser;
import view.ILogInController;

public class LogInController implements ILogInController {
	/** Implementation for login/lougout */

	private List<ASystemUser> userList = new ArrayList<ASystemUser>();

	public LogInController(List<ASystemUser> userList) {
		this.userList = userList;
	}

	/**
	 * Sets the status to logged in
	 * @param login
	 *            the login of a specific user
	 * @param password
	 *            the password of a specific user
	 */
	@Override
	public void userLogin(String login, String password) {
		if (userExists(login) && checkPassword(login, password) && !isLoggedIn(login)) {
			for (ASystemUser user : userList) {
				if (user.getLogin().equals(login)) {
					user.login();
					break;
				}
			}
		}
	}

	/**
	 * Sets the status to logged out
	 * @param login
	 *            the login of a specific user
	 */
	@Override
	public void userLogout(String login) {
		if (userExists(login)) {
			for (ASystemUser user : userList) {
				if (user.getLogin().equals(login)) {
					user.logout();
					break;
				}
			}
		}
	}

	/**
	 * Checks if a user exists
	 * @param login
	 *            the login of a specific user
	 * @return true if user exists
	 */
	public boolean userExists(String login) {
		boolean exists = false;
		for (ASystemUser user : userList) {
			if (user.getLogin().equals(login)) {
				exists = true;
				break;
			}
		}
		if (!exists)
			throw new UserLoginFailedException("User does not exist!");

		return exists;
	}

	/**
	 * Checks if user entered the right password
	 * @param login
	 *            the login of a specific user
	 * @param password
	 *            the password of a specific user
	 * @return true if password is correct
	 */
	public boolean checkPassword(String login, String password) {
		boolean checkPassword = false;
		for (ASystemUser user : userList) {
			if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
				checkPassword = true;
				break;
			}
		}
		if (!checkPassword)
			throw new UserLoginFailedException("Password is wrong!");

		return checkPassword;
	}

	/**
	 * Checks if a user is allready logged in
	 * @param login
	 *            the login of a specific user
	 * @return true if user is allready logged in
	 */
	public boolean isLoggedIn(String login) {
		boolean isLoggedIn = false;
		for (ASystemUser user : userList) {
			if (user.getLogin().equals(login) && user.isLoggedIn()) {
				isLoggedIn = true;
				break;
			}
		}
		if (isLoggedIn)
			throw new UserLoginFailedException("User is allready logged in!");

		return isLoggedIn;
	}
}
