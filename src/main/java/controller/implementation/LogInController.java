/*l
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.util.ArrayList;
import java.util.List;

import controller.ILogInController;
import controller.exceptions.UserLoginFailedException;
import srs.SystemUser;

public class LogInController implements ILogInController {
	/** Implementation for login/lougout */

	private List<SystemUser> userList = new ArrayList();

	public LogInController(List<SystemUser> userList) {
		this.userList = userList;
	}

	/**
	 * Sets the status to logged in
	 * 
	 * @param login
	 *            the login of a specific user
	 * @param password
	 *            the password of a specific user
	 */
	@Override
	public void userLogin(String login, String password) {
		if (exists(login) && checkPassword(login, password) && !isLoggedIn(login)) {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getLogin().equals(login)) {
					userList.get(i).login();
					break;
				}
			}
		}
	}

	/**
	 * Sets the status to logged out
	 * 
	 * @param login
	 *            the login of a specific user
	 */
	@Override
	public void userLogout(String login) {
		if (exists(login)) {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getLogin().equals(login)) {
					userList.get(i).logout();
					break;
				}
			}
		}
	}

	/**
	 * Checks if a user exists
	 * 
	 * @param login
	 *            the login of a specific user
	 * @return true if user exists
	 */
	public boolean exists(String login) {
		boolean exists = false;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getLogin().equals(login)) {
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
	 * 
	 * @param login
	 *            the login of a specific user
	 * @param password
	 *            the password of a specific user
	 * @return true if password is correct
	 */
	public boolean checkPassword(String login, String password) {
		boolean checkPassword = false;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getLogin().equals(login) && userList.get(i).getPassword().equals(password)) {
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
	 * 
	 * @param login
	 *            the login of a specific user
	 * @return true if user is allready logged in
	 */
	public boolean isLoggedIn(String login) {
		boolean isLoggedIn = false;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getLogin().equals(login) && userList.get(i).isLoggedIn()) {
				isLoggedIn = true;
				break;
			}
		}
		if (isLoggedIn)
			throw new UserLoginFailedException("User is allready logged in!");

		return isLoggedIn;
	}
}
